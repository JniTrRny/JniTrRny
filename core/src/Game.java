// THE EPIC ADVENTURE STARTS HERE

import java.util.*;

/** PROJECT - OUTSIDE WORLD */
public class Game{
    //Universal values of the game

    /** Universal scanners */
    static Scanner scan = new Scanner(System.in), scan2 = new Scanner(System.in);
    /** Game values stored as int */
    static int supply = 0, totalDistance = 0, nextDistance = 0, skipEvent = 0;
    /** Towns */
    static String currentTown, nextTown;
    /** Explored Towns */
    static String[] exploredTowns;

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

        System.out.print("\nPress enter to continue.");
        scan2.nextLine(); //Enter to continue

        //Prologue
        //ASCII here too probably
        System.out.print("\n\n\nOnce upon a time, there is a person, living in a small and remote village.");
        scan2.nextLine();
        System.out.print("That person is you.");
        scan2.nextLine();
        System.out.print("From sheer remoteness, you were disconnected from the outside world since you were born.");
        scan2.nextLine();
        System.out.print("One day, you pondered, \"What would the outside world look like?\"");
        scan2.nextLine();
        System.out.println("Out of curiosity, you decided to leave the village and travel...");

        System.out.println("\nPress enter to continue.");

        scan2.nextLine();

        //Supply selection
        System.out.println("\n\n\nBefore you go, you decided to stop at the village shop. What do you want to buy?");
        System.out.println("1) Nothing     2) Water Supply\n3) Food Supply  4) Water and Food"); //Supply choice
        supply = scan.hasNextInt() ? Math.clamp(scan.nextInt(), 1, 4) * 20 : 0;

        System.out.print("You traveled with ");

        switch(supply){
            case 20 -> System.out.print("nothing.");
            case 40 -> System.out.print("several bottles of water.");
            case 60 -> System.out.print("several can foods");
            case 80 -> System.out.print("large amount of food and water.");
        }

        //First journey
        System.out.println("\n\nYour journey has started.");
        scan2.nextLine();

        nextDistance = 12;
        randomEvent(); //First event of the game

        System.out.println("You depleted your food supply along the way.");
        calculateSupply(12); //Deplete the supply

        //First destination, neighboring village, tutorial ends here
        currentTown = "neighboring village";
        nextDistance = 0;

        System.out.print("\n\n\nYou've arrived at a neighboring village, locating 12 miles away from where we left.");
        scan2.nextLine();
        System.out.print("It is a small, remote village like yours.");
        scan2.nextLine();
        System.out.print("It is also the only other human settlement you know of.");
        scan2.nextLine();
        System.out.print("From this onwards, the real journey will really begins.");
        scan2.nextLine();

        calculateDistance(12); //Add distance
        townChoices();
    }

    /** Calculate the amount of supply left after one travel. */
    public static void calculateSupply(int distance){
        supply -= distance; //Changes the supply value after it is depleted from travel

        if(supply <= 20){
            System.out.print("You ran out of supplies.");
        }else if(supply <= 40){
            System.out.print("You ran out of stock food.");
        }else if(supply <= 60){
            System.out.print("You still have some food left.");
        }else{
            System.out.print("You still have plentiful amount of food and water.");
        }

        if(supply > 0){
          //Report supply
          System.out.print(" Can travel for another " + supply + " mile(s).");
          scan2.nextLine();
        }else if(supply == 0){
          //Edge case
          System.out.print(" Cannot travel further anymore.");
          scan2.nextLine();
        }else{
          //Starved to death
          System.out.print(" Cannot travel anymore.");
          scan2.nextLine();
          gameOver("You died from starvation."); //Game over
        }
    }

    public static void calculateDistance(int distance){
        int newDistance = totalDistance + distance; //New distance
        if(newDistance >= 250 && totalDistance < 250){
            //New distance crossed
            System.out.print("You have travelled the outside world for long and far enough.");
            scan2.nextLine();
            System.out.print("It seems like you're getting accustomed to the world.");
            scan2.nextLine();
            System.out.print("The settlements kept getting bigger the more your travel.");
            scan2.nextLine();
            System.out.print("It made you realized how small your life used to be.");
            scan2.nextLine();
        }else if(newDistance >= 1000 && totalDistance < 1000){
            //New distance crossed
            System.out.print("You have travelled the outside world so far, you're getting accustomed to them.");
            scan2.nextLine();
            System.out.print("Everyday, you're discovering more and more things unimaginable to you.");
            scan2.nextLine();
            System.out.print("So much that you decided to stop thinking about it and cope with the world instead.");
            scan2.nextLine();
            System.out.print("The towns kept getting bigger and more crowded, you begin to see cities.");
            scan2.nextLine();
            System.out.print("It made you miss your peaceful life at home.");
            scan2.nextLine();
        }

        totalDistance = newDistance; //Apply new distance to total distance
    }

    /** Arrives at a town */
    public static void townArrived(){
        //Arrived at the new town
        System.out.print("You have arrived at the " + prefix(nextTown, true) + nextTown + ", locating " + nextDistance + " miles away from " + currentTown);
        //Town description
        System.out.print(".\nThe " + prefix(nextTown, true) + nextTown + " is a " + (totalDistance >= 1000 ? "megapolis" : totalDistance >= 250 ? "town" : "village") +
        ", home to " + (totalDistance >= 1000 ? "millions of people from all over the region." : totalDistance >= 250 ? "hundreds of dwellers and workers." : "families of villagers and farmers."));
        scan2.nextLine();
        System.out.print("The " + prefix(nextTown, false) + " itself looks " +
        (totalDistance >= 1000 ? " very crowded. With its towering buildings and people in weird outfits carrying some kind of machine everywhere, it is so inconceivable to you that you stopped thinking about it."
        : totalDistance >= 250 ? Math.random() > 0.5 ? "comfortable and nice. With its dwellers working on never-seen jobs and merchants trading stuffs, you could bring many ideas back to improve your village."
        : "beautiful. With buildings layering around and people doing business, you could bring all those ideas back to improve your home."
        : Math.random() > 0.5 ? "calm and humble. With its people talking and working closely like they're families, it makes you miss your home."
        : "elegant. With its people working and playing around like families, it makes you miss your home."));
        scan2.nextLine(); //Enter to continue

        currentTown = nextTown; //Next town becomes current town
        calculateDistance(nextDistance);
        nextDistance = 0; //Resets next distance
        nextTown = ""; //Resets next town

        townChoices();
    }

    /** Choices when arriving to a town */
    public static void townChoices(){
        boolean refilled = false; //Check of player has already refilled their supply
        boolean pathFound = false; //If a new path has been found, stop the loop

        while(!pathFound){
            System.out.println("What do you want to do here?");
            System.out.println("1) Refill Supply  2) Ask people\n3) Walk around   4) Settle down"); //Town choice
            int ans = scan.hasNextInt() ? Math.clamp(scan.nextInt(), 1, 4) : 0; //TODO

            switch(ans){
                case 1 -> {
                    if(!refilled){
                        if(totalDistance < 250){
                            System.out.println("You went to a nearby shop to refill your supplies.");
                        }else if(totalDistance < 1000){
                            System.out.println("You went to a nearby town market to refill your supplies.");
                        }else{
                            System.out.println("You went to an astonishing mall to refill your supplies.");
                        }
                        System.out.print("Supply refilled. ");
                        calculateSupply(-50); //Add supply

                        refilled = true;
                    }else{
                        System.out.println("You have already refilled your supplies."); //Only refill once
                    }
                }
                case 2 -> {
                    System.out.println("You asked nearby villagers for direction.");
                    if(Math.random() > 0.35){ //RNG
                        //Found new path
                        if(totalDistance < 250){
                            System.out.println("They led you to an intersecting pathway.");
                        }else if(totalDistance < 1000){
                            System.out.println("They led you to nearby roads.");
                            System.out.println("Seems like it is designed for something else heavier than human.");
                        }else{
                            System.out.println("They led you to a highly-developed complex route.");
                            System.out.println("It is possibly designed for some kind of machine capable of speeding.");
                        }

                        scan2.nextLine();
                        newPaths(totalDistance < 250 ? 3 : 4); //New path
                        pathFound = true;
                    }else if(Math.random() > 0.1){
                        //Didn't find new path
                        System.out.println(Math.random() > 0.66 ? "You found nothing meaningful." :
                        Math.random() > 0.66 ? "You don't understand their gibberish accent." :
                        Math.random() > 0.5 ? "They don't know anything too." : "They ignored you and walked away.");
                        scan2.nextLine();
                    }else{
                        //Unlucky RNG
                        System.out.println(Math.random() > 0.66 ? "They robbed some of your supplies and ran away." :
                        Math.random() > 0.5 ? "They called police on you of suspicious activities.\nYou spent some of your supplies to release yourself." :
                        "They tricked you into submission and stole your supplies.");
                        calculateSupply(15);
                    }
                }
                case 3 -> {
                    if(totalDistance < 250){
                        System.out.print("You walked around the village.");
                    }else if(totalDistance < 1000){
                        System.out.print("You walked around the town.");
                    }else{
                        System.out.print("You walked by the towering buildings of the city.");
                    }
                    scan2.nextLine();

                    if(Math.random() > 0.6){ //RNG
                        //Found new path
                        newPaths(1);
                        pathFound = true;
                    }else{
                        //Didn't find new path
                        System.out.print(Math.random() > 0.5 ? "You found nothing meaningful." : "You feel tired of walking.");
                        scan2.nextLine();
                    }
                }
                case 4 -> {
                    System.out.print("If you settle down, your journey will end right here.");
                    scan2.nextLine();
                    System.out.println("Do you want to continue?");
                    System.out.println("1) Yes      2) No");
                    int settle = scan.hasNextInt() ? scan.nextInt() : 2; //Settle choice

                    if(settle == 1){
                        //THE END
                        System.out.print("You have decided to settle down at the " + prefix(currentTown, true) + currentTown + ".");
                        scan2.nextLine();
                        System.out.print("You contemplated your life and your long journey that leads to this point.");
                        scan2.nextLine();
                        System.out.print("You have traveled for " + totalDistance + " miles.");
                        scan2.nextLine();
                        System.out.print("You have seen many things you wouldn't should you stay at the village.");
                        scan2.nextLine();
                        System.out.print("Your long journey have continued on for far too long.");
                        scan2.nextLine();
                        System.out.print("The journey has ended.");
                        scan2.nextLine();
                        System.exit(999);
                    }
                }
            }
        }
    }

    /** Next path to choose after a stop */
    public static void newPaths(int path){
        System.out.print("You discovered the next path of your journey.");
        scan2.nextLine();
        if(totalDistance < 250){
            System.out.print(Math.random() > 0.5 ? "It is time to venture to the unknowns." : "It is time to continue this amazing journey.");
        }else if(totalDistance < 1000){
            System.out.print(Math.random() > 0.5 ? "It is time to explore the outside world." : "It is time to discover new things.");
        }else if(totalDistance < 5000){
            System.out.print(Math.random() > 0.5 ? "It is time to traverse this extraordinary world." : "It is time to visit new cities.");
        }else{
            System.out.print("It is time to wrap up your journey.");
        }
        scan2.nextLine();

        String town1 = randomName(), town2 = randomName(town1), town3 = randomName(town1, town2), town4 = randomName(town1, town2, town3); //Random next town name

        if(path > 1) System.out.println("Choose a path."); //Choosing town choice
        System.out.println("1) " + town1);
        if(path >= 2) System.out.println("2) " + town2);
        if(path >= 3) System.out.println("3) " + town3);
        if(path >= 4) System.out.println("4) " + town4);
        System.out.println("I need more time.");

        int ans = scan2.hasNextInt() ? scan2.nextInt() : -1;

        switch(ans){
            case 1 -> nextTown = town1;
            case 2 -> nextTown = town2;
            case 3 -> nextTown = town3;
            case 4 -> nextTown = town4;
            default -> {
                System.out.print("You need some more time to decide.");
                scan2.nextLine();
                System.out.print(Math.random() > 0.66 ? "Take your time." : Math.random() > 0.5 ? "Try running around to clear your mind." : "Think hard about it.");
                scan2.nextLine();
                townChoices();
            }
        }

        nextDistance = Math.max((int)Math.round(Math.random() * 5 * (totalDistance / 10f)), 10); //Random next distance, minimum is 10

        System.out.print("You have chosen " + nextTown + " as your next destination.");
        scan2.nextLine();
        System.out.print("It is " + nextDistance + " miles away from this town.");
        scan2.nextLine();
        System.out.print("The journey continues.");
        scan2.nextLine();
        System.out.println();

        travel();
    }

    /** Travelling process */
    public static void travel(){
        //Looping events until the distance is met
        for(int i = Math.max(nextDistance / 10, 1); i > 0; i--){
            System.out.print(Math.random() > 0.66 ? "You depleted some of your supplies along the way." :
            Math.random() > 0.5 ? "You bust through your supplies along the way." : "You ate your food supplies along the way.");
            scan2.nextLine();
            calculateSupply(i * 10); //Calculate supply along the way

            if(i <= 2){
                System.out.println("You are almost at the next destination.");
            }else if(i <= (nextDistance / 20)){
                System.out.println("You are half way there to the next destination.");
            }else if(i <= 5){
                System.out.println("You are approaching the next destination steadily.");
            }

            randomEvent();
        }

        System.out.print("\nThe next destination is just in your sight.");
        scan2.nextLine();

        if(nextDistance % 10 > 0){
            System.out.print("But before that, you chuckle some of your last supplies.");
            scan2.nextLine();
            calculateSupply(nextDistance % 10); //Calculate leftover supplies before approaching new town
        }else{
            System.out.print("You should be approaching very shortly.");
            scan2.nextLine();
        }

        townArrived(); //Arrived at new town
    }

    public static String randomName(String... duplicate){ //TODO too complicated, make it enum and more complicated
        String[] names;
        if(totalDistance < 250){
            //Medieval-ish names
            names = new String[]{"Gogrell", "Loghedge", "Sulton", "Flat Hills", "Wandermoore", "Forht Wurst", "Planus", "Maureus", "Shalge", "Spring Falls",
            "Blueridge", "Gammerbon", "Quenton", "Tappine", "Kelfalls", "Lugner", "Aureole", "Hellenis", "Torkus", "Hamsterdams", "Saint Faint", "Hemperton",
            "Sevielle", "Nouvelle", "Simperton", "Ramrion", "Samsion", "Taelom", "Chomlite", "Jaylen", "Shyyrea", "Lakeland", "Granet", "Tulland", "Chula", "Spiel",
            "Redrogue", "Reskslope", "Flendus", "Sacharina", "Almari", "Shala'an", "La Marika", "Schellin", "Shariala", "Achareus"};
        }else if(totalDistance < 1000){
            //Contemporary names
            names = new String[]{"Addinton", "Durrie", "Calgeir", "Landen", "Shoraphora", "Monapolis", "Neapolis", "Caitlin", "Lake Aura", "Mickipolis",
            "San Angelo", "Haven", "York", "Thrace", "Alexandra", "Big Mountain Town", "Helmburg", "Athenaville", "Deep Valley", "Engburg", "Milano",
            "Ayodhya", "Winter Falls", "Galveston", "Dohnver", "Daviston", "Ausgustus", "Tucusz", "Rapid City", "Stark City", "Enoyne", "Envoyage", "O'hara",
            "Hampston", "North City", "South City", "East City", "West City", "Sharwa Kano", "Shlomburg", "Santa Valley", "Clark City", "Ocean City", "Lake City",
            "Los Athos", "Rammerling", "Kingston", "Tomston", "Mineta", "Ayshrin", "Holmeston", "Stanton Town", "Falcon City", "Campus City", "Hermelet",
            "Stone Falls", "Herline", "Quartz City", "Los Alligatos", "Chocoland", "Luzeman", "Selena", "Moscalp", "Timperton", "Mexokan", "Spring City"
            "Summer Town", "Gypsum City", "Strait City", "Boublex", "Flandburg", "Mondburg", "Schellge", "Shraines" "New Capital"};
        }else{
            //Futuristic names
            names = new String[]{"United City", "Odyssea", "Halcyon", "Gomorrah", "Aughrus", "Federal City", "Teksas", "Altopolis", "Malrusia", "Disappointment",
            "Kashyyk", "Coruscant", "Alderaa", "Kamino City", "Felucia", "Naboo", "Sednapolis", "Erisapolis", "Makeopolis", "Deep Blue City", "Skyrux", "Taurax",
            "New Hamsterdams", "New Hellington", "Provincial Capital", "National Capital", "Holy Capital", "Royal Capital", "Imperial Capital", "Genova", "Polluxis",
            "Columbus", "Hellwonder", "NE0 District", "Manderson", "Valenia", "Texopolis", "Perker", "Lake Ultron", "Selexia", "Pulsar City", "Novasavia",
            "Spiral City", "Heliopolis", "Terra District", "Lunar District", "Solar District", "Ezene District", "Cheese District", "Astronova", "Astropolis"
            "Axiom Alpha", "Axiom Beta", "Axiom Gamma", "Axiom Delta", "Axiom Sigma"};
        }
        String name = names[(int)Math.round(Math.random() * (names.length - 1))]; //Random the name

        //Only unique name
        while(Arrays.stream(duplicate).toList().contains(name)){
            name = names[(int)Math.round(Math.random() * (names.length - 1))]; //Random name again if duplicated
        }
        return name;
    }

    public static String randomName(){
        return randomName("");
    }

    /** Town prefix */
    public static String prefix(String town, boolean of){
        return town.endsWith("Town") || town.endsWith("City") || town.endsWith("District") || town.endsWith("Capital") ? of ? "city" : "" :
        totalDistance >= 1000 ? "city" + (of ? " of " : "") : totalDistance >= 250 ? "town" + (of ? " of " : "") : "village" + (of ? " of " : "");
    }

    //Events along the way
    //Boar
    public static void eventBoar(){
        System.out.print("Along the way, you stumble upon a boar.");
        scan2.nextLine();
        System.out.print("It doesn't seem to notice you."); //TODO noticed you option
        scan2.nextLine();
        System.out.println("What do you do?");
        System.out.println("1) Run away   2) Attack\n3) Play dead   4) Ride on it"); //Boar choice

        int ans = scan.hasNextInt() ? Math.clamp(scan.nextInt(), 1, 4) : 1;

        switch(ans){
            case 1 -> {
                System.out.print("You ran away from the boar.");
                scan2.nextLine();
                System.out.print("It tried to follow you, but stopped midway.");
                scan2.nextLine();
            }
            case 2 -> {
                if(Math.random() > 0.65){ //RNG
                    //Lucky RNG; Killed the boar
                    System.out.print("You attacked and killed the boar.");
                    scan2.nextLine();
                    System.out.print("You gathered its meat to your supply. ");
                    calculateSupply(-30); //Add supply
                }else if(Math.random() > 0.05){
                    //Normal RNG; Boar ran away
                    System.out.print("You attacked the boar.");
                    scan2.nextLine();
                    System.out.print("It suffered injuries and ran away.");
                    scan2.nextLine();
                }else{
                    //Unlucky RNG; Got killed by the boar
                    System.out.print("You attacked the boar.");
                    scan2.nextLine();
                    System.out.print("It fought back and killed you.");
                    scan2.nextLine();
                    gameOver("You were killed by the boar."); //Game over
                }
            }
            case 3 -> {
                if(Math.random() > 0.2){ //RNG
                    //Lucky
                    System.out.print("You played dead, the boar could not care less for your actions.");
                    scan2.nextLine();
                }else{
                    //Unlucky
                    System.out.print("You played dead, but the boar noticed your actions.");
                    scan2.nextLine();
                    System.out.print("It casually murdered and munched you.");
                    scan2.nextLine();
                    gameOver("You were killed by the boar."); //Game over
                }
            }
            case 4 -> {
                if(Math.random() > 0.9){
                    //Easter egg
                    System.out.println("You rode the boar!");
                    System.out.println("You used it to go to the next destination quicker.");
                    skipEvent += 1; //Skips one event, essentially travelling "less"
                }else{
                    System.out.println("You tried to ride on the boar, but it noticed and attacked you instead.");
                    scan2.nextLine();
                    gameOver("You were killed by the boar."); //Game over
                }
            }
        }
    }

    //Thieves TODO too boring
    public static void eventThieves(){
        System.out.print("While you travel, you stumble upon a group of thieves.");
        scan2.nextLine();
        System.out.print("They're hunting for your stuff.");
        scan2.nextLine();
        System.out.println("What do you do?");
        System.out.println("1) Run away   2) Attack\n3) Surrender   4) Do nothing"); //Thief choice

        int ans = scan.hasNextInt() ? Math.clamp(scan.nextInt(), 1, 4) : 4;

        switch(ans){
            case 1 -> {
                System.out.print("You ran away from the thieves.");
                scan2.nextLine(); //Enter to progress
                if(Math.random() > 0.2){
                    //Lucky
                    System.out.print("They couldn't catch you.");
                    scan2.nextLine(); //Enter to progress
                }else{
                    //Unlucky
                    System.out.print("They caught up to you and murdered you.");
                    scan2.nextLine(); //Enter to progress
                    gameOver("You were murdered by a group of thieves."); //Game over
                }
            }
            case 2 -> {
                System.out.print("You attacked the thieves.");
                scan2.nextLine();
                if(Math.random() > 0.15){ //RNG
                    //Normal RNG - Thieves ran away
                    System.out.print("They were hurt and ran away.");
                    scan2.nextLine();
                }else{
                    //Unlucky RNG - Got killed by the thieves
                    System.out.print("They fought back and killed you.");
                    scan2.nextLine();
                    gameOver("You were killed by a group of thieves."); //Game over
                }
            }
            case 3 -> {
                System.out.print("You surrendered to the thieves.");
                scan2.nextLine();
                System.out.print("They stole some of your supplies.");
                calculateSupply(15);
                scan2.nextLine();
            }
            case 4 -> {
                System.out.print("You did nothing.");
                scan2.nextLine();
                if(Math.random() > 0.25){ //Lucky
                    System.out.print("They were scared by your presence and ran away.");
                }else{ //Unlucky
                    System.out.print("They stole some of your supplies.");
                    scan2.nextLine();
                    calculateSupply(25);
                }
                scan2.nextLine();
            }
        }
    }

    //Abandoned Houses
    public static void eventHouse(){
        System.out.print("During your journey, you stumble upon an abandoned house.");
        scan2.nextLine();
        System.out.print("It seems like it has been left for a very long time.");
        scan2.nextLine();
        System.out.println("What do you do?");
        System.out.println("1) Ignore    2) Search\n3) Walk around   4) Blow up"); //House choice

        int ans = scan.hasNextInt() ? Math.clamp(scan.nextInt(), 1, 4) : 4;

        switch(ans){
            case 1 -> {
                System.out.print("You ignored the house and progressed forward.");
                scan2.nextLine(); //Enter to progress
            }
            case 2 -> {
                System.out.print("You searched inside the house.");
                scan2.nextLine();
                if(Math.random() > 0.65){ //RNG
                    //Normal RNG
                    System.out.println("You found some useful supplies left by previous adventurers.");
                    calculateSupply(-40); //Add supply
                }else if(Math.random() > 0.15){
                    //Normal RNG
                    System.out.print(Math.random() > 0.5 ? "You found nothing meaningful." : "You found rotting supplies laying around the house, it smells so bad you ran away.");
                    scan2.nextLine();
                }else{
                    //Unlucky RNG
                    System.out.print("You stepped on an unstable floor and fell to death.");
                    scan2.nextLine();
                    gameOver("You fell from high place."); //Game over
                }
            }
            case 3 -> {
                System.out.print("You walked around the house.");
                scan2.nextLine();
                if(Math.random() > 0.08){ //RNG
                    //Normal RNG
                    System.out.print(Math.random() > 0.66 ? "You feel good." : Math.random() > 0.5 ? "You feel somewhat eerily." : "You are very scared.");
                    scan2.nextLine();
                }else{
                    //Unlucky RNG
                    System.out.print("You accidentally stepped on a deadly trap and died.");
                    scan2.nextLine();
                    gameOver("You stepped on a deadly trap."); //Game over
                }
            }
            case 4 -> {
                System.out.print("You blew the house up.");
                scan2.nextLine(); //TODO
            }
        }
    }

    /** Random events */
    public static void randomEvent(){
        if(skipEvent > 0){
            //Skipping event
            skipEvent--;
            supply += 10; //Silently adding supply, same effect as if you reduced the distance
            return;
        }

        if(Math.random() > 0.66){
            eventBoar(); //Boar event
        }else if(Math.random() > 0.5){
            eventThieves(); //Thieves event
        }else{
            eventHouse(); //House event
        }
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
} //TODO separate tutorial from main process - make another, more sensational ending - coin system would be great too - more events
//TODO print method - random method - choice default fix

