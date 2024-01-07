package com.hreinn.skaalmaster.challanges;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SinglePlayerCards {

    ArrayList<String> cards = new ArrayList<>();
    List<String> list;

    public SinglePlayerCards(){
        list = Arrays.stream(Gdx.files.internal("text/single-player-cards.txt")
                .readString()
                .split("%%"))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    public String pop(){
        if(cards.size() == 0){
            cards.addAll(list);
        }
        return formatInstruction(cards.remove((int) (cards.size() * Math.random())));
    }

    private String formatInstruction(String instruction) {
        StringBuilder res = new StringBuilder();
        int lineLength = 0;
        for (int i = 0; i < instruction.length(); i++) {
            char c = instruction.charAt(i);
            res.append(c);
            if(c == ' ' && lineLength > 22){
                lineLength = 0;
                res.append('\n');
            }
            lineLength++;
        }
        return res.toString();
    }
}
