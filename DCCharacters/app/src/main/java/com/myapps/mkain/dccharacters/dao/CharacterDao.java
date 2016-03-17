package com.myapps.mkain.dccharacters.dao;

import com.myapps.mkain.dccharacters.model.Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterDao {

    private static CharacterDao instance;
    private List<Character> charactersList = new ArrayList<Character>();

    private CharacterDao () {

    }

    public static synchronized CharacterDao getInstance() {
        if (instance == null) {
            return instance = new CharacterDao();
        }
        return instance;
    }

    public List<Character> findAll() {
        return charactersList;
    }

    public void save(Character character) {
        if (character == null) {
            throw new IllegalArgumentException();
        }
        CharacterDao.getInstance().findAll().add(character);
    }

}
