
public class Main {
    public static void main(String[] args) {
        //Para optimizar el código, prodecemos a escribirlo en la forma "switch".
        //Ponemos valor nulo de forma genérica, pero sabemos que ejecutando nos dará un NullPointerException.
        String block= null;
        switch (block){
            case "IRON":
            case "BED":
            case "BED_BLOCK":
            case "BRICK_STAIRS":
            case "BIRCH_WOOD_STAIRS":
            case "BREWING_STAND":
            case "CAKE":
            case "CAKE_BLOCK":
            case "CAULDRON":
            case "CHEST":
            case "CLAY":
            case "SAND":
            case "BURNING_FURNACE":
            case "COBBLESTONE_STAIRS":
            case "FENCE":
            case "FENCE_GATE":
            case "FIRE":
            case "GRAVEL":
            case "IRON_DOOR_BLOCK":
            case "IRON_FENCE":
            case "IRON_DOOR":
            case "LADDER":
            case "MELON":
            case "LEAVES":
            case "LOCKED_CHEST":
            case "SANDSTONE_STAIRS":
            default:
                break;
        }
        }
    }
