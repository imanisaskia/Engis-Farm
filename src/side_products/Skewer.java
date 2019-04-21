package side_products;

public class Skewer extends SideProduct {
		private int price;          //ChickenAndEggSkewer price
        private int ingredient1;    //Ingredient1 type
        private int ingredient2;    //Ingredient2 type

        /*constructor*/
        public Skewer(){
			price = 40;
			ingredient1=5;
			ingredient2=6;
		}

        /*return ChickenAndEggSkewer price*/
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


