package ru.lis154.restServiceStock.entity;


import com.google.gson.annotations.SerializedName;

public enum Type {
    @SerializedName("INFO")
    INFO,
    @SerializedName("ERROR")
    ERROR
}
