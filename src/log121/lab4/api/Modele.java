package log121.lab4.api;

import java.io.Serializable;
import java.util.Observable;

public abstract class Modele<T extends ICloneable> extends Observable implements IOriginateur<T>, Serializable  {
	

}
