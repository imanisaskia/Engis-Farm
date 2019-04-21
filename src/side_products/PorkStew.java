package side_products;

/**
 * Kelas PorkStew terdiri dari atribut bahan dan harga.
 * Kelas PorkStew digunakan untuk menginstansiasi objek PorkStew.
 * @author Lydia Astrella Wiguna (13517019)
 */
public class PorkStew extends SideProduct {
		private int price;          //PorkStew price
        private int ingredient1;    //Ingredient1 type
        private int ingredient2;    //Ingredient2 type

        /**constructor*/
        public PorkStew(){
			price = 38;
			ingredient1=4;
			ingredient2=5;
		}

        /**return PorkStew price*/
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


