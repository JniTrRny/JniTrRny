// PROJECT: OUTSIDE WORLD

import java.util.*;

/** PROJECT - OUTSIDE WORLD */
public class Game{
    //Universal values of the game

    /** Universal scanners */
    static Scanner input = new Scanner(System.in), line = new Scanner(System.in);
    /** Game universal values (int) */
    static int totalDistance = 0, nextDistance = 0, skipEvent = 0, gameDay = 1;
    /** Game universal values (float) */
    static float money = 0, supply = 0, withheldSupply = 0, gameTime = 0, timeElapsed = 0;
    /** Conversion values */
    static float luck = 1f, dts = 1f, dtt = 10f, stc = 0.5f;
    /** Multipliers */
    static float supplyMultiplier = 1f, supplyConsumingMultiplier = 1f, moneyMultiplier = 1f, moneySpendingMultiplier = 1f, courtChanceMultiplier = 1f;
    /** Towns */
    static String currentTown, nextTown;
    /** Explored Towns */
    static String[] exploredTowns;
    /** Final distance values, used for progression in story. */
    static final int townProgression = 250, cityProgression = 1000, endProgression = 5000;
    /** Final event/time values */
    static final int eventFrequency = 10, eventTime = 50, dayNightCycle = 2500, dayTime = (dayNightCycle/2) + (dayNightCycle/10), nightTime = (dayNightCycle/2) - (dayNightCycle/10);
    /** Cheats */
    static boolean unlimitedSupply = false, unlimitedMoney = false, instantTravel = false;

    public static void main(String[] args){
        //Start of the game
        //ASCII from https://patorjk.com/software/taag/
        System.out.println(" ░▒▓██████▓▒░ ░▒▓█▓▒░░▒▓█▓▒░░▒▓████████▓▒░░▒▓███████▓▒░░▒▓█▓▒░░▒▓███████▓▒░ ░▒▓████████▓▒░      ░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░ ░▒▓██████▓▒░ ░▒▓███████▓▒░ ░▒▓█▓▒░       ░▒▓███████▓▒░  ");
        System.out.println("░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░   ░▒▓█▓▒░   ░▒▓█▓▒░       ░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░             ░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░       ░▒▓█▓▒░░▒▓█▓▒░ ");
        System.out.println("░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░   ░▒▓█▓▒░   ░▒▓█▓▒░       ░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░             ░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░       ░▒▓█▓▒░░▒▓█▓▒░");
        System.out.println("░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░   ░▒▓█▓▒░    ░▒▓██████▓▒░ ░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░        ░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓███████▓▒░ ░▒▓█▓▒░       ░▒▓█▓▒░░▒▓█▓▒░ ");
        System.out.println("░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░   ░▒▓█▓▒░          ░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░             ░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░       ░▒▓█▓▒░░▒▓█▓▒░");
        System.out.println("░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░   ░▒▓█▓▒░          ░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░             ░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░       ░▒▓█▓▒░░▒▓█▓▒░");
        System.out.println(" ░▒▓██████▓▒░  ░▒▓██████▓▒░    ░▒▓█▓▒░   ░▒▓███████▓▒░ ░▒▓█▓▒░░▒▓███████▓▒░ ░▒▓████████▓▒░       ░▒▓█████████████▓▒░  ░▒▓██████▓▒░ ░▒▓█▓▒░░▒▓█▓▒░░▒▓████████▓▒░░▒▓███████▓▒░");

        System.out.println("\n\n                        WELCOME TO THE -OUTSIDE WORLD-!                          ");
        System.out.println("               YOUR EPIC ADVENTURE STARTS HERE!               ");

        print("\nPress enter to continue.");

        //Prologue
        //ASCII here too probably
        print("\n\n\nOnce upon a time, there is a person, living in a small and remote village.");
        print("That person is you.");
        print("From sheer remoteness, you were disconnected from the outside world since you were born.");
        print("One day, you pondered, \"What would the outside world look like?\"");
        print("Out of curiosity, you decided to leave the village and travel...");

        tutorial(); //Commence tutorial
    }

    public static void tutorial(){
        resetProgression(); //Reset game progression

        //Supply selection
        print("\n\n\nYou collected your essential stuff, your savings of " + money + " coins, and bid farewell to your home.");
        print("Before you head out, you decided to stop at the village shop.");
        int ans = choices("What do you want to buy?", 4, "Canned Food (20 c)", "Packaged Meals (30 c)", "Meal Jumbo (40 c)", "Nothing"); //Supply choice

        if(ans != 4){
            print("You spent " + ((ans + 1) * 10 * moneyMultiplier * moneySpendingMultiplier) + " coins to buy " + (ans + 1) * 20 * supplyMultiplier + " miles worth of supplies.");
            money -= (ans + 1) * 10 * moneyMultiplier * moneySpendingMultiplier;
            supply += (ans + 1) * 20 * supplyMultiplier;
        }

        System.out.print("You left your village with " + money + " coins and ");

        switch(ans){
            case 1 -> print("several canned foods.");
            case 2 -> print("several packages of meal.");
            case 3 -> print("all sorts of meal in large amount.");
            case 4 -> print("no plans ahead whatsoever.");
        }

        //First journey
        print("\nYour journey has started.\n");

        nextDistance = rng(10, 5);
        randomEvent(); //First event of the game

        print("You depleted your food supply along the way.");
        updateSupply(-nextDistance * dts * supplyConsumingMultiplier); //Deplete the supply
        updateDistance(nextDistance); //Add distance
        updateTime(nextDistance * dtt);

        //First destination, neighboring village, tutorial ends here
        currentTown = "neighboring village";
        nextDistance = 0;

        print("\n\n\nYou've arrived at a neighboring village, locating 12 miles away from where we left.");
        print("It is a small, remote village like yours.");
        print("It is also the only other human settlement you know of.");
        print("From this onwards, the real journey will really begins.");

        townChoices();
    }

    /** Calculate & catch the amount of money. Ratio of money currency is 1:2 of supply value. 1:10 of skip event, 1 per mile. */
    public static void updateMoneyRaw(float amount){
        if(unlimitedMoney){
            money = Float.POSITIVE_INFINITY;
            print("You have unlimited money.");
            return;
        }

        money += amount * moneyMultiplier; //Changes the money value;

        //Money status
        if(money > 500){ //500+
            System.out.print("You are very prosperous.");
        }else if(money > 250){ //250 - 500
            System.out.print("You are wealthy.");
        }else if(money > 100){ //100 - 250
            System.out.print("You are fairly self-contained.");
        }else if(money > 25){ //25 - 100
            System.out.print("You still have some money.");
        }else if(money > 0){ //1 - 25
            System.out.print("You are running out of money.");
        }else if(money == 0){ //0
            print("You are broke. (" + amount + ")"); //DEBUG TODO
        }else{
            print("You are indebted of " + Math.abs(money) + " coins.");
        }

        //Amount of money
        if(money > 1){
            print(" Got " + money + " (" + (amount > 0 ? "+" + amount : amount) + ") coins left.");
        }else if(money == 1){
            print(" Got " + money + " (" + (amount > 0 ? "+" + amount : amount) + ") coin left.");
        }
    }

    /** Updates money (capped to 0) */
    public static void updateMoney(float amount){
        updateMoneyRaw(amount >= 0 || money >= Math.abs(amount) ? amount : -money); //Caps money to positive value or zero
    }

    /** Spends money */
    public static void spentMoney(float spent, Runnable accept, Runnable reject){
        if(money >= spent || unlimitedMoney){
            accept.run();
            updateMoney(-spent * moneySpendingMultiplier);
        }else{
            reject.run();
        }
    }

    public static void spentMoney(float spent, Runnable accept){
        spentMoney(spent, accept, () -> print("You don't have enough money to buy that."));
    }

    /** Calculate & catch the amount of supply. */
    public static void updateSupply(float amount){
        if(unlimitedSupply){
            supply = Float.POSITIVE_INFINITY; //TODO don't use max value or infinity
            print("You have unlimited supplies.");
            return;
        }

        supply += amount * supplyMultiplier; //Changes the supply value

        if(supply > 250){ //250+
            System.out.print("You have a large amount of food supplies.");
        }else if(supply > 100){ //100 - 250
            System.out.print("You have plentiful amount of food supplies.");
        }else if(supply > 50){ //50 - 100
            System.out.print("You have a good amount of food supplies.");
        }else if(supply > 25){ //25 - 50
            System.out.print("You still have some food left.");
        }else if(supply > 0){ //1 - 25
            System.out.print("You are low on supply.");
        }else{
            System.out.print("You ran out of supply.");
        }

        if(supply > 1){
            //Report supply
            print(" Can travel for another " + supply / dts + " miles.");
        }else if(supply >= -eventFrequency){
            //Very low supply
            print(" Cannot travel further anymore.");
        }else{
            //Starved to death
            print(" You are starving.");
            gameOver("You died from starvation."); //Game over
        }
    }

    /** Calculate & catch change in distance */
    public static void updateDistance(int distance){
        int newDistance = totalDistance + distance; //New distance
        if(newDistance >= townProgression && totalDistance < townProgression){
            //New distance crossed
            print("You have travelled the outside world for long and far enough.");
            print("It seems like you're getting accustomed to the world.");
            print("The settlements kept getting bigger the more your travel.");
            print("It made you realized how small your life used to be.");
        }else if(newDistance >= cityProgression && totalDistance < cityProgression){
            //New distance crossed
            print("You have travelled the outside world so far, you're getting accustomed to them.");
            print("Everyday, you're discovering more and more things unimaginable to you.");
            print("So much that you decided to stop thinking about it and cope with the world instead.");
            print("The towns kept getting bigger and more crowded, you begin to see cities.");
            print("It made you miss your peaceful life at home.");
        }

        totalDistance = newDistance; //Apply new distance to total distance
    }

    /** Updates game time */
    public static void updateTime(float time){
        gameTime += time;
        timeElapsed += time;

        //New day
        if((gameTime / dayNightCycle) + 1 % 2 == 0){
            gameDay++;
            timeElapsed = 0;
        }

        print("Game time: " + gameTime + "     |     Time elapsed: " + timeElapsed + " (+" + time + ")" + "Day " + gameDay); //DEBUG
    }

    /** Arrives at a town */
    public static void townArrived(){
        //Arrived at the new town
        print("\n\nYou have arrived at the " + prefix(nextTown, true) + nextTown + ", locating " + nextDistance + " miles away from " + currentTown + ".");
        //Town description
        print("The " + prefix(nextTown, true) + nextTown + " is a " + (totalDistance >= cityProgression ? "megapolis" : totalDistance >= townProgression ? "town" : "village") +
                ", home to " + (totalDistance >= cityProgression ? "millions of people from all over the region." : totalDistance >= townProgression ? "hundreds of dwellers and workers." : "families of villagers and farmers."));
        print("The " + prefix(nextTown, false) + " itself looks " +
                (totalDistance >= cityProgression ? " very crowded. With its towering buildings and people in weird outfits carrying some kind of machine everywhere, it is so inconceivable to you that you stopped thinking about it."
                        : totalDistance >= townProgression ? random(50) ? "comfortable and nice. With its dwellers working on never-seen jobs and merchants trading stuffs, you could bring many ideas back to improve your village."
                        : "beautiful. With buildings layering around and people doing business, you could bring all those ideas back to improve your home."
                        : random(50) ? "calm and humble. With its people talking and working closely like they're families, it makes you miss your home."
                        : "elegant. With its people working and playing around like families, it makes you miss your home."));

        currentTown = nextTown; //Next town becomes current town
        nextTown = ""; //Resets next town
        nextDistance = 0; //Resets next distance

        townChoices();
    }

    /** Choices when arriving to a town */
    public static void townChoices(){

        while(true){
            if(timeElapsed <= dayTime / 4f){
                print("\n\nLet's look around for something to do.");
            }else if(timeElapsed <= dayTime / 2f){
                print("\n\nYou've been where for a while now.");
            }else if(timeElapsed <= dayTime - eventTime){
                //One event left until nighttime
                print("\n\nIt's evening now, places are starting to close.");
                print("You might want to find a place to stay or start travelling further.");
            }else{
                print("\n\n\n\nIt's nighttime. All place are closed. Find a place to stay.");
            }

            switch(choices("What do you want to do here?", "Refill Supply", "Ask people", "Walk around", "Settle down")){
                case 1 -> { //TODO nighttime closed
                    //Refill Supplies
                    if(timeElapsed <= nightTime - eventTime){
                        if(totalDistance < townProgression){
                            print("You went to a nearby shop to look for supplies.");
                        }else if(totalDistance < cityProgression){
                            print("You went to the town market to look for supplies.");
                        }else{
                            print("You went to a big mall to look for supplies.");
                        }

                        int ans = choicesBuying("What food do you want to buy?", 4, new int[]{10, 20, 30, 0}, "Canned Food", "Packaged Food", "Energizing Meal", "Cancel");
                        float cost = ans * 10 * moneySpendingMultiplier;

                        if(ans != 4){
                            System.out.print("Supply refilled. ");
                            updateSupply(cost / stc); //Add supply
                        }

                        updateTime(eventTime);
                    }else{
                        //Closes early
                        print("Supply shops are closed.");
                        print("You might want to come check again in the morning.");
                    }
                }

                case 2 -> {
                    //Ask townspeople
                    if(totalDistance < townProgression){
                        print("You asked nearby villagers for direction.");
                    }else if(totalDistance < cityProgression){
                        print("You asked the townspeople for direction.");
                    }else{
                        print("You asked a group of locals for direction.");
                    }

                    if(random(20)){
                        //Found new path
                        if(totalDistance < townProgression){
                            print("They led you to an interesting pathway.");
                        }else if(totalDistance < cityProgression){
                            print("They led you to nearby trails.");
                            print("Seems like it is designed for something heavier than human.");
                        }else{
                            print("They led you to a highly-developed complex route.");
                            print("It is possibly designed for some kind of machine capable of speeding.");
                        }
                        newPaths(totalDistance < townProgression ? 3 : 4); //New path
                    }else if(random(80)){
                        //Random events TODO met crime syndicate, met traders, met someone who needs to pay
                        switch(rng(1, 3)){
                            case 1, 2 -> {
                                print("They told you knew the way, but you have to pay them to tell you.");
                                if(choicesBuying("What do you do?", new int[]{rng(9, 6), 0}, "Pay them", "Walk away") == 1){
                                    print("You paid them money to led you to the way.");
                                    if(random(75)){
                                        //Real pathway
                                        print("They led you to a secret pathway only they knows.");
                                        newPaths(rng(2, 1));
                                    }else if(random(50)){
                                        //Fake pathway
                                        print("They led you to nearby trails, but it doesn't lead to the new path.");
                                        print(random(33) ? "They ran away before you could catch them." : random(50) ? "You got scammed hard." : "Your disappointment is immeasurable and your day is ruined.");
                                    }else{
                                        //Beat you up
                                        print("They led you to a dead end street and beat you up.");
                                        print("They stole some more money from you too.");
                                        updateMoney(-rng(7, 4));
                                    }
                                }else{
                                    print("You declined to offer and walked away.");
                                }
                            }
                            case 3 -> {
                                print(random(33) ? "They beat you up and robbed your money." :
                                random(50) ? "They pretended to lead you around, but then pickpockets you and ran away." :
                                "They tricked you into submission and stole your money.");
                                updateMoney(-rng(12, 12));
                            }
                            case 4 -> {
                                //Called the police
                                print("They called police on you of suspicious activities.");
                                committedCrime("suspicious activities", 25, 50); //Accused of suspicious activities
                            }
                        }
                    }else{
                        //Didn't find new path
                        print(random(25) ? "You found nothing meaningful." :
                        random(33) ? "You don't understand what they're talking about." :
                        random(50) ? "They have no clue too." : "They ignored you and walked away.");
                    }

                    updateTime(eventTime);
                }

                case 3 -> {
                    //Walking around the town
                    if(totalDistance < townProgression){
                        print("You walked around the village.");
                    }else if(totalDistance < cityProgression){
                        print("You walked around the town.");
                    }else{
                        print("You walked by the towering buildings of the city.");
                    }

                    if(random(15)){ //RNG
                        //Found new path
                        newPaths(rng(1, 2));
                    }else{
                        //Walking events
                        switch(rng(1, 1)){
                            case 1 -> {
                                //Found money
                                print("While you're walking, you found some money on the street.");
                                print("You wanted to pick it up, but you're afraid it might be a theft.");

                                if(choices("What do you do?", "Collect", "Ignore")){
                                    //Collected the money
                                    print("You picked it up and put it in your pockets.");
                                    updateMoney(rng(10, 15)); //Add money

                                    //RNG - Someone called the police
                                    if(random(20)){
                                        print("But apparently, someone saw you and called the police.");
                                        committedCrime("theft", 15, 10);
                                    }
                                }else{
                                    //Ignored the money
                                    print("You ignored the money and continued with your business.");
                                }
                            }
                            case 2 -> {
                                //Found suspicious acts
                                print("While you're walking, you found someone doing suspicious activities.");

                                switch(choices("What do you do?", 4, "Report", "Talk to them", "Threaten them", "Ignore")){
                                    case 1 -> {
                                        print("You reported them to the police.");

                                        if(random(50)){
                                            print("You got awarded some money for reporting them.");
                                            updateMoney(rng(25, 10));
                                        }else if(random(75)){
                                            print("They ran away before the police could come.");

                                            if(random(50)){
                                                print("They thanked you and gave you some money for reporting clues.");
                                                updateMoney(rng(15, 10));
                                            }else if(random(75)){
                                                print("They warned you not to false report as you could face jail time.");
                                            }else{
                                                print("They arrested you for wasting their time.");
                                                committedCrime("false report", 10, 75); //False report
                                            }
                                        }else{
                                            print("The police came but they saw nothing suspicious.");
                                            print("Instead, they arrest you for suspicious activities for wasting their time.");
                                            committedCrime("suspicious activities", 25, 25); //Accused of suspicious activities
                                        }
                                    }
                                    case 2 -> {
                                        print("You approached and talked to them.");

                                        if(random(35)){
                                            print("They offered you money to turn a blind eye about it.");
                                            updateMoney(rng(5, 5));
                                        }else if(random(25)){
                                            print("They beat you up out of fear and stole your money.");
                                            updateMoney(-rng(7, 8));
                                        }else if(random(15)){
                                            print("But while you're talking to them, someone saw you all and called the police.");
                                            committedCrime("suspicious activities", 25, 25); //Accused of suspicious activities
                                        }else if(random(20)){
                                            print("You talked about how their business could land them in jail, and offer to help them.");
                                            print("They disagreed, but they saw interest in you.");
                                            print("They offered you to join their group instead.");
                                            skipEvent += 2;
                                        }else{
                                            print("They saw you and ran away before you could get any chance to talk to them.");
                                        }
                                    }
                                    case 3 -> {
                                        print("You threatened to call the police on them.");
                                        if(random(40)){
                                            print("They gave you some money to keep secret about it.");
                                            updateMoney(rng(8, 13));
                                        }else if(random(25)){
                                            print("They ran away out of fear.");
                                        }else{
                                            print("They beat you up before you could call the police.");
                                            print("They stole your money and food.");
                                            updateMoney(-rng(12, 8));
                                            updateSupply(-rng(7, 8));
                                        }
                                    }
                                    case 4 -> print("You ignored them and continued with your business.");
                                }
                            }
                            //case 3 ->
                            //case 4 ->
                            //case 5 ->
                            default -> print(random(50) ? "You found nothing meaningful." : "You feel tired of walking."); //Didn't find anything
                        }
                    }

                    updateTime(eventTime);
                }

                case 4 -> {
                    print("If you settle down, your journey will end right here.");
                    boolean settle = choices("Do you want to continue?", "Yes", "No"); //Settle choice

                    if(settle){
                        //THE END
                        print("You have decided to settle down at the " + prefix(currentTown, true) + currentTown + ".");
                        print("You contemplated your life and your long journey that leads to this point.");
                        print("You have traveled for " + totalDistance + " miles.");
                        print("You have seen many things you wouldn't should you stay at the village.");
                        print("Your long journey have continued on for far too long.");
                        print("The journey has ended.");

                        System.exit(999);
                    }
                }
            }
        }
    }

    /** Next path to choose after a stop */
    public static void newPaths(int path){
        print("You discovered the next path of your journey.");
        if(totalDistance < townProgression){
            print(random(50) ? "It is time to venture to the unknowns." : "It is time to continue this amazing journey.");
        }else if(totalDistance < cityProgression){
            print(random(50) ? "It is time to explore the outside world." : "It is time to discover new things.");
        }else if(totalDistance < endProgression){
            print(random(50) ? "It is time to traverse this extraordinary world." : "It is time to visit new cities.");
        }else{
            print("It is time to wrap up your journey.");
        }

        String town1 = randomName(), town2 = randomName(town1), town3 = randomName(town1, town2), town4 = randomName(town1, town2, town3); //Random next town name

        if(path > 1) System.out.println("Choose a path."); //Choosing town choice
        System.out.println("1) " + town1);
        if(path >= 2) System.out.println("2) " + town2);
        if(path >= 3) System.out.println("3) " + town3);
        if(path >= 4) System.out.println("4) " + town4);
        System.out.println("I need more time.");

        int ans = input.hasNextInt() ? input.nextInt() : -1;

        switch(ans){ //TODO prevent option
            case 1 -> nextTown = town1;
            case 2 -> nextTown = town2;
            case 3 -> nextTown = town3;
            case 4 -> nextTown = town4;
            default -> {
                print("You need some more time to decide.");
                print(random(33) ? "Take your time." : random(50) ? "Try running around to clear your mind." : "Think hard about it.");
                return;
            }
        }

        nextDistance = rng(10, totalDistance/5); //Random next distance

        print("You have chosen " + nextTown + " as your next destination.");
        print("It is " + nextDistance + " miles away from this town.");
        print("The journey continues...");
        System.out.println();

        travel();
    }

    /** Travelling process TODO make it customizable (eventFrequency, nextDistance) */
    public static void travel(){
        //Looping events until the distance is met
        for(int i = Math.max(nextDistance / eventFrequency, 1); i > 0; i--){
            if(instantTravel){
                //Instant travel
                print("Initiating instant travel...");
                break;
            }

            if(skipEvent > 0 || random(5)){
                //Skips event
                print(random(33) ? "Speeding forward..." : random(50) ? "Rushing up..." : "Travelling at tremendous speed...");
                updateDistance(eventFrequency); //Update distance
                updateTime((eventFrequency * dtt) / 2);
                if(skipEvent > 0) skipEvent--;
                continue;
            }else{
                //Destination update
                if(i <= 2){
                    //Less than 2 events left
                    print("You are almost at the next destination.");
                }else if(i == (nextDistance / 20)){
                    //Half way
                    print("You are half way to the next destination.");
                }else{
                    print(random(25) ? "You are travelling..." : random(33) ? "Moving forward..." : random(50) ? "Journey onwards..." : "Let's continue...");
                }
            }

            randomEvent(); //Random an event

            print(random(33) ? "You depleted some of your supplies along the way." :
            random(50) ? "You bust through your supplies along the way." : "You ate your food supplies along the way.");

            updateSupply(-eventFrequency * dts * supplyConsumingMultiplier); //Calculate supply along the way
            updateDistance(eventFrequency); //Update distance
            updateTime(eventFrequency * dtt);
        }

        print("\nThe next destination is just in your sight.");

        if(nextDistance % eventFrequency > 0 || instantTravel){
            //Leftover distance
            print("But before that, you chuckle some of your last supplies.");
            updateSupply(-((nextDistance * dts * supplyConsumingMultiplier) % eventFrequency)); //Calculate leftover supplies before approaching new town
            updateDistance(nextDistance % eventFrequency); //Update leftover distance
            updateTime((nextDistance * dtt) % eventFrequency);
        }else{
            print("You should be approaching very shortly.");
        }

        townArrived(); //Arrived at new town
    }

    /** Accused of a crime.
     * @param crime crime committed/accused.
     * @param bail amount of money needed to bail out of the jail. Also used to determine the seriousness of the crime.
     * @param chance chance of success in fighting, if the crime is obvious, chances are 0%, if the crime is unfounded, chances are >50%
     */
    public static void committedCrime(String crime, float bail, int chance){
        print("You were accused of " + crime + ".");

        if(choices("Is the accusation true?", "Confess", "Deny")){
            //Confessed
            print("You confessed to the accusations.");
            print("You were charged of " + crime + " and is sentenced to jail.");

            spentMoney(bail, () -> {
                print("You can bail yourself for " + bail + " coins.");
                boolean bailed = choices("Do you want to bail?", "Yes", "No");
                if(bailed) print("You spent your money to bail yourself.");
            }, () -> {
                print("You don't have enough money to bail yourself.");
                //probation committed crime
                gameOver("You ended up in jail."); //Game over TODO continues after jail
            });
        }else{
            //Did not confess
            print("You did not confess to the accusations.");
            print("You challenged the accuser for false accusation.");
            if(bail >= 15 && random(Math.max(10 - (chance / bail), 9) * 10)){
                lawsuit(crime, bail, chance);
            }else{
                //Negotiate in the police station
                print("The police told you to clear things out before the case escalated.");
                print("They summoned the accuser to the police station to talk with you.");
                print("You talked with the accuser to find the common ground to end the case.");
                print(random(50) ? "You explained them their story and how it was a misunderstanding." : "They explained the situation in their perspective and what they knew.");
                if(random(chance)){
                    int comps = rng(Math.round(bail - (bail/4)), Math.round(bail/2));
                    print("It was a misunderstanding and the accuser withdraw the case.");
                    print("They agreed to pay the compensation of " + comps + " coins to you.");
                    print("Case closed.");
                    updateMoney(comps);
                }else{
                    int comps = rng(Math.round(bail - (bail/2)), Math.round(bail/4));
                    print("They requested you to pay the compensation of " + comps + " coins.");

                    if(money >= comps){
                        if(choicesBuying("What do you do?", new int[]{comps, 0}, "Accept", "Refuse") == 1){
                            print("You agreed to pay " + comps + " coins for the accuser to withdraw the case.");
                            print("Case closed.");
                        }else{
                            print("You refused to pay the compensation of " + comps + " coins.");

                            if(random(35)){
                                //Reconsider with reduced price
                                int newComps = rng(Math.round(comps - (bail/4)), Math.round((bail/8)));
                                print("The accuser asked you to reconsider, this time with the reduced price of " + newComps + " coins.");
                                if(choicesBuying("What do you do?", new int[]{newComps, 0}, "Accept", "Refuse") == 1){
                                    print("You agreed to pay " + newComps + " coins for the accuser to withdraw the case.");
                                    print("Case closed.");
                                }else{
                                    print("You refused to pay the compensation of " + newComps + " coins.");
                                    lawsuit(crime, bail, chance);
                                }
                            }else{
                                lawsuit(crime, bail, chance);
                            }
                        }
                    }else{
                        //Not enough money TODO bank system and gets money before you leave a town
                        print("But apparently, you don't have enough money to pay all of that.");
                        print("You don't have a choice but to loan money to pay them.");
                        updateMoneyRaw(-comps); //Spends money and be in debt
                    }
                }
            }
        }
    }

    /** Court case TODO in the future, merge crime and lawsuit and uniform into a class */
    public static void lawsuit(String crime, float bail, int chance){
        print("Let's continue in the court of law.");

        int lawyerChance = 75;
        float confidence = 0f, confidenceMultiplier = 0.75f;

        switch(choicesBuying("What lawyer would you hire?", 1, new int[]{0, 20, 40}, "Public Defender (0 c)", "Law Associate", "Attorney")){
            case 1 -> print("You hired a Public Defender to represent you in the lawsuit.");
            case 2 -> {
                print("You hired a law associate to represent you in the lawsuit.");
                lawyerChance = 100;
                confidenceMultiplier = 1f;
            }
            case 3 -> {
                print("You hired a professional attorney to represent you in the lawsuit.");
                lawyerChance = 120;
                confidenceMultiplier = 1.2f;
            }
        }

        print("Your hired lawyer asked you some questions to help them with the case:");
        confidence += choices("Would you please explain the situation?", "Explain in detail", "Explain obscurely") ? 20 : -10;
        confidence += choices("Are there any witnesses?", "Yes", "No") ? 25 : -15;
        confidence += choices("Are there biases in the case?", "Yes", "No") ? 30 : 0;

        print("Your lawyer inspected your answers closely.");
        print("Lawyer chance: " + lawyerChance + "   Confidence: " + confidence); //DEBUG

        if(chance >= 60 && confidence > 0){
            //Supportive
            print("Thanks to your helpful insight, they gained additional resources to support you.");
            print("They are confident that you'd win the case.");
            lawyerChance += confidence * confidenceMultiplier;
        }else if(chance >= 30){
            //Neutral
            print("Unfortunately, Your insight did not provide them any leverage to the case.");
            print("But, they will try their best to protect you in the court.");
            lawyerChance += rng(0, Math.round((confidence * confidenceMultiplier) / 2f));
        }else{
            //Negative
            if(lawyerChance > 75 && (lawyerChance + confidence < lawyerChance - lawyerChance/2f)){
                //Replaces lawyer with a Public Defender
                print("They came with the conclusion that they cannot accept the case.");
                print("The Public Defender should be in place for your missing lawyer.");
                lawyerChance = 75;
            }else if(confidence < 0){
                //Low winning chance, but more confidence
                print("From the surface, they knew that you have a low chance of winning.");
                print("But thanks to your helpful insight, they've gained confidence to support you.");
                print("They're quite confident that you'll win the case despite all the odds.");
                lawyerChance -= confidence * confidenceMultiplier;
            }else{
                //Less winning chance
                print("Based on your answers, they concluded that the case isn't on your side.");
                print("They are not fully confident that they can protect you.");
                lawyerChance -= confidence * confidenceMultiplier;
            }
        }

        boolean guilty = !random(chance * (lawyerChance / 100f) * luck * courtChanceMultiplier);

        print("You were tried before a jury.");
        print("The verdict has been made.");

        if(guilty){
            print("You have found to be GUILTY!");
            //TODO
        }else{
            print("You have found to be NOT GUILTY!");
            print("You were acquitted of " + crime + ".");
            print("The court has ordered the plaintiff to compensate you.");
            updateMoney(rng(Math.round(bail - (bail /4)), Math.round(bail)));
            //TODO
            print("Case closed.");
        }
    }

    public static String randomName(String... duplicate){ //TODO too complicated, make it enum and more complicated
        String[] names;
        if(totalDistance < townProgression){
            //Medieval-ish names
            names = new String[]{"Mohraht", "Loghedge", "Sulton", "Flat Hills", "Wandermoore", "Forht Wurst", "Planus", "Maureus", "Shalge", "Spring Falls",
                    "Blueridge", "Gammerbon", "Quenton", "Tappine", "Kelfalls", "Lugner", "Aureole", "Hellenis", "Torkus", "Hamsterdams", "Saint Faint", "Hemperton",
                    "Sevielle", "Nouvelle", "Simperton", "Ramrion", "Samsara", "Taelom", "Chomlite", "Jaylen", "Shreia", "Oppeland", "Tualope", "Tulland", "Chuland", "Spiel",
                    "Redrogue", "Garalopa", "Flacade", "Sacharina", "Almara", "Shala'an", "La Marika", "Medeli", "Shariala", "Achareus"};
        }else if(totalDistance < cityProgression){
            //Contemporary names
            names = new String[]{"Landington", "Durnishia", "Gaiari", "Loneston", "Shoraphora", "Monapolis", "Neapolis", "Caitlin", "Lake Aura", "Mickipolis", "Tanisha",
                    "San Angelo", "Havene", "Yorktown", "Triade", "Alexandra", "Grand Mount", "Helmburg", "Athenaville", "Deep Valley", "Engburg", "Chylia",
                    "Ayodhya", "Winter Falls", "Galveston", "Shdever", "Daviston", "Ausgustus", "Tucusz", "Rapid City", "Stark City", "Enoyne", "Envoyage", "O'hara",
                    "Hampston", "North City", "South City", "East City", "West City", "Sharwa Kano", "Shlomburg", "Santa Valley", "Dashar City", "Ocean City", "Lake City",
                    "Los Athos", "Rammerling", "Kingston", "Tomston", "Mineta", "Ayshrin", "Holmeston", "Stanton Town", "Falcon City", "Campus City", "Hermelet",
                    "Stone Falls", "Herline", "Quartz City", "Mavericks", "Chocoland", "Godeman", "Selena", "Moscalp", "Timperton", "Mexokan", "Spring City",
                    "Summer Town", "Gypsum City", "Strait City", "Boublex", "Flandburg", "Mondburg", "Schellge", "Shraines", "New Capital"};
        }else{
            //Futuristic names
            names = new String[]{"United City", "Odyssea", "Halcyon", "Gomorrah", "Aughrus", "Federal City", "Teksas", "Altopolis", "Malrusia", "Disappointment", "Miserable",
                    "Kashyyk", "Coruscant", "Alderaa", "Kiminore City", "Felucia", "Naboo", "Sednapolis", "Erisapolis", "Makeopolis", "Deep Blue City", "Skyrux", "Taurax",
                    "New Hamsterdams", "New Hellington", "Provincial Capital", "National Capital", "Holy Capital", "Royal Capital", "Imperial Capital", "Genova", "Polluxis",
                    "Columbus", "Hellwonder", "NE0 District", "Manderson", "Valenia", "Texopolis", "Perker", "Lake Ultron", "Selexia", "Pulsar City", "Novasavia",
                    "Spiral City", "Heliopolis", "Terra District", "Lunar District", "Solar District", "Ezene District", "Cheese District", "Astronova", "Astropolis",
                    "Axiom Alpha", "Axiom Beta", "Axiom Gamma", "Axiom Delta", "Axiom Sigma"};
        }
        String name = names[rng(0, names.length - 1)]; //Random the name

        //Only unique name
        while(Arrays.stream(duplicate).toList().contains(name)){
            name = names[rng(0, names.length - 1)]; //Random name again if duplicated
        }
        return name;
    }

    public static String randomName(){
        return randomName("");
    }

    /** Town prefix TODO too complicated */
    public static String prefix(String town, boolean of){
        return town.endsWith("Town") || town.endsWith("City") || town.endsWith("District") || town.endsWith("Capital") ? of ? "city" : "" :
                totalDistance >= cityProgression ? "city" + (of ? " of " : "") : totalDistance >= 250 ? "town" + (of ? " of " : "") : "village" + (of ? " of " : "");
    }

    //Events along the way TODO mafia, illness, positive events to boost
    //Boar
    public static void eventBoar(){
        boolean noticed = false; //Whether the boar noticed the player, affecting RNG

        print("Along the way, you stumble upon a boar.");
        if(random(65)){
            //Did not notice
            print("It doesn't seem to notice you.");
        }else{
            //Noticed
            print("It is aiming to kill you.");
            noticed = true;
        }

        switch(choices("What do you do?", "Run away", "Attack", "Play dead", "Ride on it")){
            case 1 -> {
                print("You ran away from the boar.");
                if(random(noticed ? 60 : 95)){
                    print("It tried to follow you, but stopped midway.");
                }else{
                    print("It chased after you and killed you.");
                    gameOver("You were killed by the boar."); //Game over
                }
            }
            case 2 -> {
                if(random(noticed ? 20 : 40)){ //RNG
                    //Lucky RNG; Killed the boar
                    print("You attacked and killed the boar.");
                    print("You gathered its meat to your supply.");
                    updateSupply(rng(25, 15)); //Add supply
                }else if(random(noticed ? 80 : 95)){
                    //Normal RNG; Boar ran away
                    print("You attacked the boar.");
                    print("It suffered injuries and ran away.");
                }else{
                    //Unlucky RNG; Got killed by the boar
                    print("You attacked the boar.");
                    print("It fought back and killed you.");

                    gameOver("You were killed by the boar."); //Game over
                }
            }
            case 3 -> {
                if(random(noticed ? 0 : 80)){ //RNG
                    //Lucky
                    print("You played dead, the boar could not care less for your actions.");
                }else{
                    //Unlucky
                    print("You played dead, but the boar noticed your actions.");
                    print("It casually murdered and munched you.");

                    gameOver("You were killed by the boar."); //Game over
                }
            }
            case 4 -> {
                if(random(noticed ? 1 : 10)){
                    //Easter egg
                    System.out.println("You rode the boar!");
                    System.out.println("You used it to go to the next destination quicker.");
                    skipEvent += 1; //Skips one event, essentially travelling "less"
                }else{
                    print("You tried to ride on the boar, but it noticed and attacked you instead.");
                    gameOver("You were killed by the boar."); //Game over
                }
            }
        }

        updateTime(eventTime);
    }

    //Thieves TODO mafia, they are of a powerful crime syndicate. Different event for TOWN and up
    public static void eventThieves(){
        boolean vicious = false; //Whether they're vicious or not, affecting RNG

        print("While you travel, you stumble upon a group of thieves.");
        if(random(65)){
            //Not vicious
            print("They're hunting for your stuff.");
        }else{
            //Vicious
            print("They're excited to torment their next victim.");
            vicious = true;
        }

        switch(choices("What do you do?", "Run away", "Attack", "Surrender", "Negotiate")){
            case 1 -> {
                print("You ran away from the thieves.");
                if(random(vicious ? 50 : 80)){
                    //Lucky
                    print("You outran them onto a safe space.");
                }else{
                    //Unlucky
                    print("They caught up to you and murdered you.");
                    gameOver("You were murdered by a group of thieves."); //Game over
                }
            }
            case 2 -> {
                print("You attacked the thieves.");
                if(random(vicious ? 60 : 85)){ //RNG
                    //Normal RNG - Thieves ran away
                    print("They were hurt and ran away.");
                }else{
                    //Unlucky RNG - Got killed by the thieves
                    print("They fought back and murdered you.");
                    gameOver("You were murdered by a group of thieves."); //Game over
                }
            }
            case 3 -> {
                print("You surrendered to the thieves.");

                if(money == 0){
                    //Broke
                    print("You didn't have any money to give to them.");
                    if(random(vicious ? 50 : 75)){
                        //Lucky
                        print("They left you alone as you have no use for them.");
                    }else{
                        //Unlucky
                        print("They beat you up and murdered you.");
                        gameOver("You were murdered by a group of thieves."); //Game over
                    }
                }else{
                    if(money >= 20){
                        print("You gave some of your money to them.");
                        updateMoney(-rng(10, 5));
                    }else{
                        print("Since you are low on money, you gave all of your money to them.");
                        updateMoney(-money);
                    }
                }

                //Threaten for more money, only occurs if you still have some money left after first steal
                if(money >= 25 && random(vicious ? 50 : 25)){
                    print("They threatened you for more money.");
                    print("If you do not comply, they're going to do it by force.");

                    switch(choices("What do you do?", "Comply", "Refuse", "Attack", "Negotiate")){
                        case 1 -> {
                            print("You complied with them and gave some more money.");
                            updateMoney(-rng(7, 8));
                        }
                        case 2 -> {
                            print("You refused to comply with them.");
                            if(random(vicious ? 30 : 60)){
                                //Lucky RNG
                                print("They beat you up and stole your money and supplies.");
                                updateMoney(-money / 10); //10% of your money
                                updateSupply(-rng(10, 20)); //Steals supply
                            }else{
                                //Unlucky RNG
                                print("They beat you up and brutally murdered you.");
                                gameOver("You were murdered by a group of thieves."); //Game over
                            }
                        }
                        case 3 -> {
                            print("You attacked the thieves.");
                            if(random(vicious ? 50 : 75)){
                                //Lucky
                                print("They were hurt and ran away.");
                            }else{
                                //Unlucky
                                print("They fought back and murdered you.");
                                gameOver("You were murdered by a group of thieves."); //Game over
                            }
                        }
                        case 4 -> {
                            print("You negotiate with them for less money.");
                            if(random(vicious ? 10 : 20)){
                                print("You talked about how you're travelling alone and money is necessary for your well-being.");
                                print("They were surprised by your innate skills.");
                                print("They requested you to join their group.");
                                skipEvent += 2; //Skips 2 events
                            }else if(random(vicious ? 60 : 80)){
                                print("They agreed with your negotiation.");
                                print("You gave them a little bit of money.");
                                updateMoney(-rng(5, 5));
                            }else{
                                print("They refused to comply with your negotiation.");
                                print("They stole more money from you.");
                                updateMoney(-rng(10, 10));
                            }
                        }
                    }
                }
            }
            case 4 -> {
                print("You negotiate with them for less money.");
                if(money >= 20){
                    if(random(vicious ? 5 : 15)){ //Lucky
                        print("You talked about how you're travelling alone and money is necessary for your well-being.");
                        print("They were surprised by your innate skills.");
                        print("They requested you to join their group.");
                        skipEvent += 2; //Skips 2 events
                    }else if(random(vicious ? 60 : 80)){
                        print("They agreed with your negotiation.");
                        print("You gave them a little bit of money.");
                        updateMoney(-rng(5, 5));
                    }else{ //Unlucky
                        print("They couldn't care less and stole your money anyways.");
                        updateMoney(-rng(10, 5));
                    }
                }else if(money > 0){
                    //Nearly broke
                    print("But since you are low on money, you gave them all of what you have anyways.");
                    updateMoney(-money);
                }else{
                    //Broke
                    print("But since you are broke, you didn't have any money to give to them.");
                    if(random(vicious ? 50 : 70)){
                        //Lucky
                        print("They left you alone as you have no use for them.");
                    }else{
                        //Unlucky
                        print("They beat you up and murdered you.");
                        gameOver("You were murdered by a group of thieves."); //Game over
                    }
                }
            }
        }

        updateTime(eventTime);
    }

    //Abandoned house
    public static void eventHouse(){
        print("During your journey, you stumble upon an abandoned house.");
        print("It seems like it has been left for a very long time.");

        switch(choices("What do you do?", 1, "Ignore", "Search", "Walk around", "Blow up")){
            case 1 -> print("You ignored the house and progressed forward.");
            case 2 -> {
                print("You searched inside the house.");
                if(random(40)){ //RNG
                    //Normal RNG
                    print("You found some useful supplies left by previous adventurers.");
                    updateSupply(rng(30, 20)); //Add supply
                    updateMoney(rng(15, 5)); //Add money
                }else if(random(90)){
                    //Normal RNG
                    print(random(50) ? "You found nothing meaningful." : "You found rotting supplies laying around the house, it smells so bad you ran away.");
                }else{
                    //Unlucky RNG
                    print("You stepped on an unstable floor and fell to death.");
                    gameOver("You fell from high place."); //Game over
                }
            }
            case 3 -> {
                print("You walked around the house.");
                if(random(80)){
                    //Normal events
                    switch(rng(1, 1)){
                        case 1 -> {
                            print("You found an old wheeled vehicle.");
                            if(random(40)){
                                print("You tried to start it, but it broke down and crashed.");
                                print(random(33) ? "What a waste." : random(50) ? "That's a very disappointing false hope." : "Should've had checked it before starting.");
                            }else{
                                print("You started its engine and used it to speed up to your next destination.");
                                skipEvent += 2;
                            }
                        }
                        case 2 -> {
                            print("You found some useful supplies frozen in a box.");
                            updateSupply(rng(10, 20));
                        }
                        default -> print(random(33) ? "You feel good." : random(50) ? "You feel somewhat eerily." : "You are very scared.");
                    }
                }else{
                    //Unlucky RNG
                    print("You accidentally stepped on a deadly trap and died.");
                    gameOver("You stepped on a deadly trap."); //Game over
                }
            }
            case 4 -> {
                print("You blew the house up.");
                if(random(50)){ //Lucky
                    print("You found a pathway to the basement of the house.");

                    if(choices("Do you want to explore it?", "Yes", "No")){
                        //Go to the basement
                        print("You went down to explore the basement.");
                        if(random(5)){
                            //Super lucky
                            print("You found a treasure chest!");
                            print("It contains many items of great value.");
                            updateMoney(rng(50, 100)); //Enormous amount of money
                        }else if(random(15)){
                            //Lucky
                            print("You found a mysterious chest.");

                            if(choices("Do you want to open it?", "Yes", "No")){
                                //Opened the chest
                                print("You decided to open the chest.");
                                if(random(20)){
                                    print("You found some items of value.");
                                    updateMoney(rng(25, 35)); //Add money
                                }else{
                                    print("You found an active bomb!");
                                    print("It blew up before you could do anything, killing you instantly.");
                                    gameOver("You were blown up."); //Game over
                                }
                            }else{
                                //Ignored the chest
                                print("You ignored the chest and moved on with your journey.");
                            }
                        }else if(random(60)){
                            //Supplies and money
                            print("You found some supplies and a little bit of money.");
                            updateSupply(rng(15, 15)); //Add supply
                            updateMoney(rng(8, 12)); //Add money
                        }else if(random(10)){
                            print("You found a");
                        }else{
                            print(random(33) ? "You found nothing of value." : random(50) ? "You found expired supplies that you cannot use." : "It's just a normal basement, nothing in there.");
                        }
                    }else{
                        print("You decided not to go and moved on with your journey.");
                    }
                }else if(random(70)){ //Neutral
                    print(random(33) ? "Nothing happened..." : random(50) ? "This is a very meaningless action." : "You feel bad about it.");
                }else{ //Unlucky
                    print("A debris flew to you and crushed you.");
                    print("The consequence of your unintelligent action led to your death.");

                    gameOver("You were crushed by a flying debris."); //Game over
                }
            }
        }

        updateTime(eventTime);
    }

    public static void eventMerchant(){
        print("Along the way, you come across a wandering merchant.");
        print("They offered to sell some of their goods to you for low price.");

        switch(choicesBuying("Which one do you what to buy?", new int[]{25, 30 ,20, /*15,*/ 0}, "Packaged Food", "Old Wagon", "Mystery Backpack", /*"Luck Potion",*/ "Nothing")){
            case 1 -> {
                print("You bought food supplies from the merchant.");
                updateSupply(30 / stc); //Add 30 coins worth of supplies (better rate than town markets)
            }

            case 2 -> {
                print("You bought an old wagon from the merchant.");
                print("You used it to speed your way to the next destination.");
                skipEvent += 3; //Skips 3 events
            }

            case 3 -> {
                print("You bought a mystery backpack from the merchant.");
                print("The merchant told you to be careful of its content.");

                if(choices("What do you do?", "Open", "Throw away")){
                    print("You opened the mystery backpack.");
                    if(random(50)){
                        print("You found some good supplies and money inside them.");
                        updateMoney(rng(5, 20));
                        updateSupply(rng(12, 18));
                    }else if(random(80)){
                        print("You found some old supplies and useless items.");
                        print(random(33) ? "Such a waste of money" : random(50) ? "What a scam." : "Your disappointment is immeasurable and your day is ruined.");
                    }else{
                        print("You found an active bomb!");
                        print("It blew up before you could do anything, killing you and the merchant.");
                        gameOver("You were blown up."); //Game over
                    }
                }else{
                    print("You threw away the backpack.");
                    print(random(33) ? "Why did you bought it in the first place?" : random(50) ? "You are not risking your life over that." : "You just wasted your hard-earned money for nothing.");
                }
            }
            /*case 4 -> {
                print("You bought a potion of luck from the merchant.");
                print("You drank the potion. Your luck increased for the next 30 miles.");
                luck = 1.2f;
                //TODO should be a consumable item-class in the future - can select if you want to drink it or not and keep it - more expensive
            }*/

            case 4 -> print("You declined the offer and continued on with your journey.");
        }

        updateTime(eventTime);
    }

    /** Random events */
    public static void randomEvent(){
        switch(rng(1, 3)){
            case 1 -> eventBoar(); //Boar event
            case 2 -> eventThieves(); //Thieves event
            case 3 -> eventHouse(); //House event
            case 4 -> eventMerchant(); //Merchant event
            //default -> miniEvents();
        }
    }

    /** Reset the game progression */
    public static void resetProgression(){
        currentTown = "Home";
        nextTown = "";
        supply = 20f; //Set difficulty
        money = 100f; //Set difficulty
        gameDay = 1;
        gameTime = timeElapsed = withheldSupply = skipEvent = totalDistance = nextDistance = 0;
    }

    /** Ends the game with whatever reason. */
    public static void gameOver(String text){
        System.out.println(" .d8888b.         d8888 888b     d888 8888888888        .d88888b.  888     888 8888888888 8888888b.  888");
        System.out.println("d88P  Y88b       d88888 8888b   d8888 888              d88P\" \"Y88b 888     888 888        888   Y88b 888");
        System.out.println("888    888      d88P888 88888b.d88888 888              888     888 888     888 888        888    888 888");
        System.out.println("888            d88P 888 888Y88888P888 8888888          888     888 Y88b   d88P 8888888    888   d88P 888");
        System.out.println("888  88888    d88P  888 888 Y888P 888 888              888     888  Y88b d88P  888        8888888P\"  888");
        System.out.println("888    888   d88P   888 888  Y8P  888 888              888     888   Y88o88P   888        888 T88b   Y8P");
        System.out.println("Y88b  d88P  d8888888888 888   \"   888 888              Y88b. .d88P    Y888P    888        888  T88b   \" ");
        System.out.println(" \"Y8888P88 d88P     888 888       888 8888888888        \"Y88888P\"      Y8P     8888888888 888   T88b 888");

        System.out.println("\nGAME OVER !");
        System.out.println(text);

        System.exit(69420); //Exit the program
    }

    //System methods

    /** Random number generation */
    public static int rng(int min, int range){
        return (int)Math.round(Math.random() * range) + min;
    }

    /** Random between true and false */
    public static boolean random(float percent){
        return Math.random() < (percent * luck / 100f);
    }

    /** Choices selection panel */
    public static int choices(String text, int defaultAns, String... options){

        while(true){
            print(text);
            for(int i = 0; i < options.length; i++){
                System.out.print((i + 1) + ") " + options[i]);
                System.out.print(i % 2 == 0 ? " ".repeat(Math.max(20 - options[i].length(), 1)) : "\n");
            }

            var in = input.nextInt();
            int ans = Integer.parseInt("" + in) == in ? in : defaultAns;
            for(int i = 0; i < options.length; i++) if(ans == i + 1) return i + 1;

            if(defaultAns != -100){
                return defaultAns;
            }else{
                print("Wrong or invalid input, please try again.");
            }
        }
    }

    /** Choices selection panel, without default choice */
    public static int choices(String text, String... options){
        return choices(text, -100, options);
    }

    /** Choices selection panel with price options */
    public static int choicesBuying(String text, int defaultAns, int[] prices, String... options){

        while(true){
            print(text);
            for(int i = 0; i < options.length; i++){
                System.out.print((i + 1) + ") " + options[i] + (prices[i] > 0 ? " (" + prices[i] + " c)" : ""));
                System.out.print(i % 2 == 0 ? " ".repeat(Math.max(20 - options[i].length(), 1)) : "\n");
            }

            var in = input.nextInt();
            int ans = Integer.parseInt("" + in) == in ? in : defaultAns;
            boolean failed = false;

            for(int i = 0; i < options.length; i++){
                if(ans == i + 1){
                    if(prices[i] > 0) spentMoney(prices[i], () -> {});
                    if(money >= prices[i]) return i + 1;
                    failed = true;
                }
            }

            if(defaultAns != -100){
                return defaultAns;
            }else if(!failed){
                print("Wrong or invalid input, please try again.");
            }
        }
    }

    /** Choices selection panel with price options, without default choice */
    public static int choicesBuying(String text, int[] prices, String... options){
        return choicesBuying(text, -100, prices, options);
    }

    /* Choices selection panel
    public static boolean choices(String text, String option1, String option2, boolean defaultAns){
        print(text);
        System.out.print("1) " + option1 + "    ");
        System.out.print("2) " + option2);

        String ans = input.nextLine();

        //ans.equals("1") || ans.equals(option1) = true
        //ans.equals("2") || ans.equals(option2) = false
        return ans.equals("1") || ans.equals(option1) || (!ans.equals("2") && !ans.equals(option2) && defaultAns);
    }
    */

    public static boolean choices(String text, String option1, String option2){
        while(true){
            print(text);
            System.out.print("1) " + option1 + "    ");
            System.out.println("2) " + option2);

            var in = input.nextInt();
            int ans = Integer.parseInt("" + in) == in && (in == 1 || in == 2) ? in : -1;

            //int ans = in.equals("1") || in.equals(option1) ? 1 : in.equals("2") && in.equals(option2) ? 2 : -1;
            if(ans != -1) return ans == 1;
            print("Wrong or invalid input, please try again.");
        }
    }

    /** Print method, enter to continue */
    public static void print(String text){
        System.out.print(text);
        line.nextLine();
    }
} //TODO make another, more sensational ending - a way to gain money - more events - rounding hell
