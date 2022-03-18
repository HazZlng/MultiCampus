package sample9;

public class MyFoodMgr {
	private Food favoriteFood;
	private Food unFavoriteFood;
	
	public MyFoodMgr() {
		super();
	}
	
	public MyFoodMgr(Food favoriteFood, Food unFavoriteFood) {
		super();
		this.favoriteFood = favoriteFood;
		this.unFavoriteFood = unFavoriteFood;
	}

	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public void setUnFavoriteFood(Food unFavoriteFood) {
		this.unFavoriteFood = unFavoriteFood;
	}

	@Override
	public String toString() {
		return "MyFoodMgr [favoriteFood=" + favoriteFood + ", unFavoriteFood=" + unFavoriteFood + "]";
	}
	
}
