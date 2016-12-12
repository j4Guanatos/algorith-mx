/**
 * Created by Sinuhe_Jaime on 12/12/2016.
 */

class Sier(val name: String, val age: Int) {
    override fun hashCode(): Int {
        return name.hashCode() + age.hashCode()
    }
}