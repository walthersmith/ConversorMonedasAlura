package com.walther.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record Code(String result,
                   String documentation,
                   String terms_of_use,
                   @SerializedName("supported_codes") List<Currency> supportedCodes
                   ) {
}