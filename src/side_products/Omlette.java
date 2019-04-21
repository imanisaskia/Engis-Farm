package side_products;

/**
 * Kelas Omlette terdiri dari atribut bahan dan harga.
 * Kelas Omlette digunakan untuk menginstansiasi objek Omlette.
 * @author Lydia Astrella Wiguna (13517019)
 */
public class Omlette extends SideProduct {
		private int price;          //Omlette price
        private int ingredient1;    //Ingredient1 type
        private int ingredient2;    //Ingredient2 type

        /**constructor*/
        public Omlette(){
			price = 18;
			ingredient1=1;
			ingredient2=2;
		}

        /**return Omlette price*/
        public int getPrice(){
			return price;
		}

        /**return Ingredient1 type*/
        public int getIngredient1(){
			return ingredient1;
		}

        /**return Ingredient2 type*/
        public int getIngredient2(){
			return ingredient2;
		}
}


