package com.rear_admirals.york_pirates;

import static java.lang.Math.max;
import static java.lang.Math.pow;

public class Department {

    private final String name;
    private String product;
    private int base_price;
    private PirateGame pirateGame;

    public Department(String name, String product, PirateGame pirateGame) {
        this.name = name;
        this.product = product;
        this.base_price = 10;
        this.pirateGame = pirateGame;
    }

    //Altered For Assessment 3

    /**
     * Upgrade ship by spending gold.
     * @return - Boolean, purchase successful
     */
    public boolean purchase() {
        if (pirateGame.getPlayer().payGold(getPrice())) {
            Ship playerShip = pirateGame.getPlayer().getPlayerShip();
            if (product == "Defence") {
                playerShip.setDefence(playerShip.getDefence() + 1);
                return true;
            } else if (product == "Attack") {
                playerShip.setAttack(playerShip.getAttack() + 1);
                return true;
            } else {
                //FIXME I'm pretty sure that this else statement returns false, even if it was successful. Also, didn't
                //  we decide not to upgrade accuracy because of the way that they implemented it?
                for (int i = 0; i < pirateGame.getPlayer().getAttacks().size(); i++) {
                    pirateGame.getPlayer().getAttacks().get(i).addAccuracy(1);
                }
            }
        }
        return false;
    }

    /**
     * Get the price of an upgrade from this department, taking into account current upgrade level
     * @return price of upgrade
     */
    public int getPrice() {
        if (product == "Defence") {
            return (int) (base_price * pow(2, max(0, pirateGame.getPlayer().getPlayerShip().getDefence() - 3)));
        } else if (product == "Attack") {
            return (int) (base_price * pow(2, max(0, pirateGame.getPlayer().getPlayerShip().getAttack() - 3)));
        } else if (product == "Accuracy") {
            return (int) (base_price * pow(2, max(0, pirateGame.getPlayer().getPlayerShip().getAccuracy() - 3)));
        } else {
            return 0;
        }
    }
    //End Altered

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
    }
}