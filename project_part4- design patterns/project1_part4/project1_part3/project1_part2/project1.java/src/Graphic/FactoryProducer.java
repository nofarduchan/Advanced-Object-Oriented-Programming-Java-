package Graphic;

public class FactoryProducer {
    public static AbstractFactory getType(String vehicleType)
    {
        if(vehicleType.equals("Land"))
        {
            return new Factory_Land();
        }
        if(vehicleType.equals("Air"))
        {
            return new Factory_Air();
        }
        if(vehicleType.equals("Marine"))
        {
            return new Factory_Marine();
        }
        return null;
    }
}
