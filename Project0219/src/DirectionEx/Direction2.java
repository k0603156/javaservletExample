package DirectionEx;
enum Direction {EAST,SOUTH,NORTH,WEST};

public class Direction2 {

	public static void main(String[] args) {
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);
		System.out.println("d3="+d3);
		
		System.out.println("d1==d2"+(d1==d2));
		System.out.println("d1==d3"+(d1==d3));
		
		System.out.println("d1.equuals(d3)?"+d1.equals(d3));
//		System.out.println("d2>d3?"+(d2>d3));err
		System.out.println("d1.compareTo(d3)"+d1.compareTo(d3));
		System.out.println("d1.compareTo(d2)="+d1.compareTo(d2));

	switch(d1) {
	case EAST:
		System.out.println("Direction is EAST");
		break;
	case WEST:
		System.out.println("Direction is WEST");
		break;
	case SOUTH:
		System.out.println("Direction is SOUTH");
		break;
	case NORTH:
		System.out.println("Direction is NORTH");
		break;
	default:
		System.out.println("Invalid direction");
		break;
	}
		Direction[] darr = Direction.values();
		for(Direction d: darr) {
			System.out.printf("%s=%d\n",d.name(),d.ordinal());
		}
	}
}


