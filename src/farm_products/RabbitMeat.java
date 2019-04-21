package farm_products;

/**
 * Kelas RabbitMeat terdiri dari atribut tipe dan harga.
 * Kelas RabbitMeat digunakan untuk menginstansiasi objek RabbitMeat.
 * @author Lydia Astrella Wiguna (13517019)
 */
public class RabbitMeat extends FarmProduct{
        private int type;   /*RabbitMeat type = 8*/
        private int price;  /*RabbitMeat price*/

        /**constructor*/
        public RabbitMeat(){
			type =6;
			price =17;
		}

        /**return RabbitMeat type*/
        public int getType(){
			return type;
		}

        /**return RabbitMeat price*/
        public int getPrice(){
			return price;
		}
}


