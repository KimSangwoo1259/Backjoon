class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int time = 0;
        int index = 0;
        int band = 0;
        final int LEN = attacks.length;
        while (time <= attacks[LEN-1][0]){
            if (time == attacks[index][0]) {
                health -= attacks[index][1];
                if (health <= 0)
                    return -1;
                time++;
                index++;
                band = 0;
                continue;
            }
            band++;
            health += bandage[1];
            if (band == bandage[0])
                health += bandage[2];

            if (health >= maxHealth)
                health = maxHealth;

            band = band % bandage[0];
            time++;
        }

        return health;
    }
}