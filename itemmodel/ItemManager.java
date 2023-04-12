package itemmodel;

public interface ItemManager {
	//Methods:
	/*
	 * Contain bunch of events that mutate the data of item
	 * This main interface provide the mean to update data(IE: for Admin)
	 */
	public void inflate(float percentage);
	public void changeBy(String id, float percentage) throws Exception;
}
