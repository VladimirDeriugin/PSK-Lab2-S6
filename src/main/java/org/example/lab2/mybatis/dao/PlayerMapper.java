package org.example.lab2.mybatis.dao;

import org.example.lab2.mybatis.model.Player;

import java.util.List;

public interface PlayerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Mon Mar 25 21:24:20 EET 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Mon Mar 25 21:24:20 EET 2024
     */
    int insert(Player row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Mon Mar 25 21:24:20 EET 2024
     */
    Player selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Mon Mar 25 21:24:20 EET 2024
     */
    List<Player> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Mon Mar 25 21:24:20 EET 2024
     */
    int updateByPrimaryKey(Player row);
}