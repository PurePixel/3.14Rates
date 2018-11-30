package testing_tools;

import combat.items.RoomUpgrade;
import combat.items.Weapon;
import combat.ship.Room;
import combat.ship.RoomFunction;
import combat.ship.Ship;

import java.util.ArrayList;
import java.util.List;


public class SampleObjects {
    public static Ship createSampleShip() {
        int crew = 5;
        List<Room> rooms = createSampleRooms();
        List<Weapon> weapons = createSampleWeapons();
        int baseHP = 100;
        int currentHP = 100;

        return new Ship(crew, rooms, weapons, baseHP, currentHP);
    }

    public static List<Room> createSampleRooms() {
        List<Room> rooms = new ArrayList<Room>();
        RoomFunction func;

        func = RoomFunction.HELM;
        rooms.add(new Room(100, 100, createSampleUpgrades(func, 0), func));
        func = RoomFunction.CROWS_NEST;
        rooms.add(new Room(150, 100, createSampleUpgrades(func, 0), func));
        func = RoomFunction.GUN_DECK;
        rooms.add(new Room(120, 100, createSampleUpgrades(func, 0), func));
        func = RoomFunction.CREW_QUARTERS;
        rooms.add(new Room(150, 100, createSampleUpgrades(func, 0), func));
        func = RoomFunction.NON_FUNCTIONAL;
        rooms.add(new Room(200, 100, createSampleUpgrades(func, 0), func));
        func = RoomFunction.NON_FUNCTIONAL;
        rooms.add(new Room(200, 100, createSampleUpgrades(func, 0), func));

        return new ArrayList<Room>();
    }

    /**
     * Creates a sample upgrade list. Creates one of a set.
     *
     * @param set The set of upgrades that you want to create. See cases in switch statement for possible sets.
     * @return A list of upgrades.
     */
    public static RoomUpgrade[] createSampleUpgrades(RoomFunction room, int set) {
        RoomUpgrade[] upgrades = new RoomUpgrade[3];
        switch (set) {
            case 0:
//              Case zero returns no upgrades
                break;
            case 1:
                upgrades[0] = new RoomUpgrade("Upgrade1", 100, 1.5, room);
                upgrades[1] = new RoomUpgrade("Upgrade2", 50, 2, room);
                break;
        }
        return upgrades;
    }

    public static List<Weapon> createSampleWeapons() {
        List<Weapon> weapons = new ArrayList<Weapon>();
        weapons.add(new Weapon("Weapon1", 50, 15, 2000, 0.05,
                0.8));
        weapons.add(new Weapon("Weapon2", 50, 15, 2000, 0.05,
                0.8));
        weapons.add(new Weapon("Weapon3", 10, 3, 1500, 0.05,
                0.8));
        weapons.add(new Weapon("Weapon4", 100, 30, 4000, 0.05,
                0.9));

        return new ArrayList<Weapon>();
    }

}