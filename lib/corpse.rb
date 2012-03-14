
class Corpse
    def initialize
        @deathliness = true
        @hungry = false
        @angry = false
    end

    def dead?
        @hungry = true
        @deathliness
    end

    def its_alive!
        @deathliness = false
        @hungry = true
    end

    def needs_brains?
        if @deathliness
        end
        #moss knows nuthin
        false
    end

    def hungry?
        @deathliness = false
        @hungry
    end

    def heckling_zach?
        false
    end

    def decapitate
        @deathliness = true
    end

end
class Corspse < Corpse
end

class Food
end

def fail
end

