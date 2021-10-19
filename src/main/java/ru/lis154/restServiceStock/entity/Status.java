package ru.lis154.restServiceStock.entity;

import com.google.gson.annotations.SerializedName;

public enum Status {
    @SerializedName("NEW")
    NEW,
    @SerializedName("COMPLETED")
    COMPLETED
}
