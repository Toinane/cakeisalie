package toinane.cakeisalie.utils;

public class ConfigInstance {
    // public Blocks blocks;
    public Cakes cakes;
    public Effects effects;

    public ConfigInstance() {
        // blocks = new Blocks();
        cakes = new Cakes();
        effects = new Effects();
    }

    // public class Blocks {
    // public boolean frosted_lava = true;
    // }

    public class Cakes {
        public boolean anniversary_cake = true;
        public boolean apple_cake = true;
        public boolean basque_cake = true;
        public boolean brownie = true;
        public boolean carrot_cake = true;
        public boolean cheese_cake = true;
        public boolean chocolate_cake = true;
        public boolean chocolate_mousse = true;
        public boolean chocolate_roll = true;
        public boolean cookies_cake = true;
        public boolean ender_cake = true;
        public boolean gold_cake = true;
        public boolean hamburger = true;
        public boolean khobzet_biscuit = true;
        public boolean lava_cake = true;
        public boolean muffins = true;
        public boolean nordic_cake = true;
        public boolean paris_brest = true;
        public boolean poisoned_cake = true;
        public boolean pumpkin_cake = true;
        public boolean redstone_cake = true;
        public boolean sandy_cake = true;
        public boolean slime_cake = true;
        public boolean spiced_cake = true;
        public boolean stars_cake = true;
        public boolean trapped_cake = true;
        public boolean watermelon_cake = true;
    }

    public class Effects {
        public boolean destruction = true;
        public boolean frost_walker = true;
        public boolean lava_walker = true;
        public boolean slime_bounce = true;
        public boolean suffocation = true;
    }
}
