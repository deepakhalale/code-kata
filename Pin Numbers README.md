
Alright, detective, one of our colleagues successfully observed our target person, Robby the robber. 
We followed him to a secret warehouse, where we assume to find all the stolen stuff. 
The door to this warehouse is secured by an electronic combination lock. Unfortunately our spy isn't sure about the PIN he saw, 
when Robby entered it.
The keypad has the following layout:
┌───┬───┬───┐
│ 1 │ 2 │ 3 │
├───┼───┼───┤
│ 4 │ 5 │ 6 │
├───┼───┼───┤
│ 7 │ 8 │ 9 │
└───┼───┼───┘
    │ 0 │
    └───┘
He noted the PIN 1357, but he also said, it is possible that each of the digits he saw could actually be another adjacent digit 
(horizontally or vertically, but not diagonally). E.g. instead of the 1 it could also be the 2 or 4. 
And instead of the 5 it could also be the 2, 4, 6 or 8.
He also mentioned, he knows this kind of locks. You can enter an unlimited amount of wrong PINs, they never finally lock the system 
or sound the alarm. That's why we can try out all possible (*) variations.
* possible in sense of: the observed PIN itself and all variations considering the adjacent digits
Can you help us to find all those variations? It would be nice to have a function, that returns list in 
Java of all variations for an observed PIN with a length of 1 to 8 digits. 
We could name the function getPINs (get_pins in python, GetPINs in C#). 
But please note that all PINs, the observed one and also the results, must be strings, because of potentially leading '0's. 




public static List<String> getPINs(String observed) {
       return null;
} // getPINs


Examples: 

"8"   =>  {"5", "7", "8", "9", "0"}
"11"  => {"11", "21", "41", "12", "22", "42", "14", "24", "44"}
"369" => {"236", "238", "239", "256", "258", "259", "266", "268", "269", "296", "298", "299", "336", "338", "339", "356", "358", "359", "366", "368", "369", "396", "398", "399", "636", "638", "639", "656", "658", "659", "666", "668", "669", "696", "698", "699"};

