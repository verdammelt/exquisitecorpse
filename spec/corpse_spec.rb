require 'corpse'

describe Corpse do
    it "is dead" do
        Corpse.new.should be_dead
    end

    it "is reanimated" do
        zombie = Corpse.new
        zombie.its_alive!
        zombie.should_not be_dead
    end

    it "no matter how dead or hungry the Corpse is Zach should not get heckled" do
        corpse = Corspse.new
        corpse.should_not be_heckling_zach

    end

    it "is hungry when it rises from the grave" do
        corpse = Corpse.new
        proc {
            corpse.its_alive!
        }.should change(corpse, :hungry?).from(false).to(true)
    end

    it "will eat" do
        food = Food.new
        corpse = Corpse.new
        corpse.its_alive!
        fail

    end

    it "live corpse will die if decapticated" do
        mike = Corpse.new
        mike.its_alive!
        mike.decapitate
        mike.should be_dead
    end
end

