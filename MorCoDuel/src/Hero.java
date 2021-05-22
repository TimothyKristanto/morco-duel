public interface Hero {
    public int attack(int hp_musuh);
    public int[] skill1(int hp_musuh, int att_musuh);
    public int[] skill2(int hp_musuh, int att_musuh);
    public void status() throws InterruptedException;
    public String[] skill1Mode();
    public String[] skill2Mode();
    public int getAtt();
}
