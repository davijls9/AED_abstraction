public class Carta {

   public static String[] faces = { "", "A", "2", "3", "4", "5", "6",
         "7", "8", "9", "10", "J", "Q", "K" };

   public static enum naipes {
      COPAS, OUROS, PAUS, ESPADAS;
   }

   public String face;
   public Carta.naipes naipe;

   public Carta(int val, Carta.naipes naipe) {
      if (val >= 1 && val <= 13)
         this.face = faces[val];
      else
         this.face = "A";
      this.naipe = naipe;
   }

   public int valor() {
      for (int i = 1; i < faces.length; i++) {
         if (this.face.equals(faces[i]))
            return i;
      }
      return -1;
   }

   public String corNaipe() {
      switch (this.naipe) {
         case OUROS:
         case COPAS:
            return "Vermelho";
         case PAUS:
         case ESPADAS:
            return "Preto";
      }
      return null;
   }

   @Override
   public String toString() {
      return this.face + " de " + this.naipe;
   }

   @Override
   public boolean equals(Object o) {
      Carta outra = (Carta) o;

      if (this.face.equals(outra.face) && (this.naipe == outra.naipe))
         return true;
      else
         return false;
   }
}