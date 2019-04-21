package farm_products;

/**
 * Kelas GoatMilk terdiri dari atribut tipe dan harga.
 * Kelas GoatMilk digunakan untuk menginstansiasi objek GoatMilk.
 * @author Lydia Astrella Wiguna (13517019)
 */
public class GoatMilk extends FarmProduct{
        private int type;   /*GoatMilk type = 4*/
        private int price;  /*GoatMilk price*/

        /**constructor */
        public GoatMilk(){
			type =4;
			price =12;
		}

        /**return GoatMilk type*/
        public int getType(){
			return type;
		}

        /**return GoatMilk price*/
        public int getPrice(){
			return price;
		}
}


