package farm_products;

/**
 * Kelas PigMeat terdiri dari atribut tipe dan harga.
 * Kelas PigMeat digunakan untuk menginstansiasi objek PigMeat.
 * @author Lydia Astrella Wiguna (13517019)
 */
public class PigMeat extends FarmProduct{
        private int type;   /*PigMeat type = 7*/
        private int price;  /*PigMeat price*/

        /** constructor */
        public PigMeat(){
			type =5;
			price =18;
		}

        /**return PigMeat type*/
        public int getType(){
			return type;
		}

        /**return PigMeat price*/
        public int getPrice(){
			return price;
		}
}


