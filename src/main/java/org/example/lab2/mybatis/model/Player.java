package org.example.lab2.mybatis.model;

public class Player {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PLAYER.ID
     *
     * @mbg.generated Mon Mar 25 21:24:20 EET 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PLAYER.FULLNAME
     *
     * @mbg.generated Mon Mar 25 21:24:20 EET 2024
     */
    private String fullname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PLAYER.TEAM_ID
     *
     * @mbg.generated Mon Mar 25 21:24:20 EET 2024
     */
    private Integer teamId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PLAYER.ID
     *
     * @return the value of PUBLIC.PLAYER.ID
     *
     * @mbg.generated Mon Mar 25 21:24:20 EET 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PLAYER.ID
     *
     * @param id the value for PUBLIC.PLAYER.ID
     *
     * @mbg.generated Mon Mar 25 21:24:20 EET 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PLAYER.FULLNAME
     *
     * @return the value of PUBLIC.PLAYER.FULLNAME
     *
     * @mbg.generated Mon Mar 25 21:24:20 EET 2024
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PLAYER.FULLNAME
     *
     * @param fullname the value for PUBLIC.PLAYER.FULLNAME
     *
     * @mbg.generated Mon Mar 25 21:24:20 EET 2024
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PLAYER.TEAM_ID
     *
     * @return the value of PUBLIC.PLAYER.TEAM_ID
     *
     * @mbg.generated Mon Mar 25 21:24:20 EET 2024
     */
    public Integer getTeamId() {
        return teamId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PLAYER.TEAM_ID
     *
     * @param teamId the value for PUBLIC.PLAYER.TEAM_ID
     *
     * @mbg.generated Mon Mar 25 21:24:20 EET 2024
     */
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}