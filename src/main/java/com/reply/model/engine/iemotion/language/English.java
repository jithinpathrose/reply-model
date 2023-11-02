package com.reply.model.engine.iemotion.language;

public class English implements  Lanuage{

    private static final String[] alphabets = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R",
            "S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","t","u","v","w",
            "x","y","z", " "};
    @Override
    public String[] alphabets() {
        return alphabets;
    }
}
