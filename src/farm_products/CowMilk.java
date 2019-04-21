package farm_products;

/**
 * Kelas CowMilk terdiri dari atribut tipe dan harga.
 * Kelas CowMilk digunakan untuk menginstansiasi objek CowMilk.
 * @author Lydia Astrella Wiguna (13517019)
 */
public class CowMilk extends FarmProduct{
        private int type;   /*CowMilk type = 3*/
        private int price;  /*CowMilk price*/

        /**constructor */
        public CowMilk(){ 
			type =3;
			price =10;
		}

        /**return CowMilk type*/
        public int getType(){
			return type;
		}

        /**return CowMilk price*/
        public int getPrice(){
			return price;
		}
}


