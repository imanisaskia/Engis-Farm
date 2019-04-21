package side_products;

public class RabbitStew extends SideProduct {
		private int price;          //BeefStew price
        private int ingredient1;    //Ingredient1 type
        private int ingredient2;    //Ingredient2 type

        /*constructor*/
        public RabbitStew(){
			price = 25;
			ingredient1=4;
			ingredient2=6;
		}

        /*return BeefStew price*/
        public int getPrice(){
			return price;
		}

        /*return Ingredient1 type*/
        public int getIngredient1(){
			return ingredient1;
		}

        /*return Ingredient2 type*/
        public int getIngredient2(){
			return ingredient2;
		}
}

