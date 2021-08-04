package com.example.bingetrack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cast {

    @SerializedName("crew")
    private List<CrewBean> crew;
    @SerializedName("cast")
    private List<CastBean> cast;
    @SerializedName("id")
    private int id;

    public List<CrewBean> getCrew() {
        return crew;
    }

    public void setCrew(List<CrewBean> crew) {
        this.crew = crew;
    }

    public List<CastBean> getCast() {
        return cast;
    }

    public void setCast(List<CastBean> cast) {
        this.cast = cast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class CrewBean {
        @SerializedName("job")
        private String job;
        @SerializedName("department")
        private String department;
        @SerializedName("credit_id")
        private String creditId;
        @SerializedName("profile_path")
        private String profilePath;
        @SerializedName("popularity")
        private double popularity;
        @SerializedName("original_name")
        private String originalName;
        @SerializedName("name")
        private String name;
        @SerializedName("known_for_department")
        private String knownForDepartment;
        @SerializedName("id")
        private int id;
        @SerializedName("gender")
        private int gender;
        @SerializedName("adult")
        private boolean adult;

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getCreditId() {
            return creditId;
        }

        public void setCreditId(String creditId) {
            this.creditId = creditId;
        }

        public String getProfilePath() {
            return profilePath;
        }

        public void setProfilePath(String profilePath) {
            this.profilePath = profilePath;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getOriginalName() {
            return originalName;
        }

        public void setOriginalName(String originalName) {
            this.originalName = originalName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKnownForDepartment() {
            return knownForDepartment;
        }

        public void setKnownForDepartment(String knownForDepartment) {
            this.knownForDepartment = knownForDepartment;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public boolean getAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }
    }

    public static class CastBean {
        @SerializedName("order")
        private int order;
        @SerializedName("credit_id")
        private String creditId;
        @SerializedName("character")
        private String character;
        @SerializedName("cast_id")
        private int castId;
        @SerializedName("profile_path")
        private String profilePath;
        @SerializedName("popularity")
        private double popularity;
        @SerializedName("original_name")
        private String originalName;
        @SerializedName("name")
        private String name;
        @SerializedName("known_for_department")
        private String knownForDepartment;
        @SerializedName("id")
        private int id;
        @SerializedName("gender")
        private int gender;
        @SerializedName("adult")
        private boolean adult;

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getCreditId() {
            return creditId;
        }

        public void setCreditId(String creditId) {
            this.creditId = creditId;
        }

        public String getCharacter() {
            return character;
        }

        public void setCharacter(String character) {
            this.character = character;
        }

        public int getCastId() {
            return castId;
        }

        public void setCastId(int castId) {
            this.castId = castId;
        }

        public String getProfilePath() {
            return profilePath;
        }

        public void setProfilePath(String profilePath) {
            this.profilePath = profilePath;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getOriginalName() {
            return originalName;
        }

        public void setOriginalName(String originalName) {
            this.originalName = originalName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKnownForDepartment() {
            return knownForDepartment;
        }

        public void setKnownForDepartment(String knownForDepartment) {
            this.knownForDepartment = knownForDepartment;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public boolean getAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }
    }
}
