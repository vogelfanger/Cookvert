package com.cookvert.util;

/**
 * Utility class for unit conversions. Contains multipliers and conversion methods for each unit.
 * Only contains static methods and should not be instantiated.
 */
public class Converter {

    //Private constructor to prevent instantiation.
    private Converter(){}

    // MASS UNIT MULTIPLIERS:

    public static final double GRAM_TO_KILOGRAM = 0.001;
    public static final double GRAM_TO_OUNCE = 0.03527396195;
    public static final double GRAM_TO_POUND = 0.002204622622;

    public static final double KILOGRAM_TO_GRAM = 1000;
    public static final double KILOGRAM_TO_OUNCE = 35.27396195;
    public static final double KILOGRAM_TO_POUND = 2.204622622;

    public static final double OUNCE_TO_GRAM = 28.34952313;
    public static final double OUNCE_TO_KILOGRAM = 0.02834952313;
    public static final double OUNCE_TO_POUND = 0.0625;

    public static final double POUND_TO_GRAM = 453.59237;
    public static final double POUND_TO_KILOGRAM = 0.45359237;
    public static final double POUND_TO_OUNCE = 16;

    // VOLUME UNIT MULTIPLIERS:

    public static final double CUP_UK_TO_CUP_US = 1.20095;
    public static final double CUP_UK_TO_DECILITER = 2.84131;
    public static final double CUP_UK_TO_DESSERTSPOON_EU = 28.41306;
    public static final double CUP_UK_TO_DESSERTSPOON_UK = 24;
    public static final double CUP_UK_TO_DESSERTSPOON_US = 28.82280;
    public static final double CUP_UK_TO_FLUID_OUNCE_UK = 10;
    public static final double CUP_UK_TO_FLUID_OUNCE_US = 9.60760;
    public static final double CUP_UK_TO_GALLON_UK = 0.0625;
    public static final double CUP_UK_TO_GALLON_US_DRY = 0.064504;
    public static final double CUP_UK_TO_GALLON_US = 0.075059;
    public static final double CUP_UK_TO_LITER = 0.28413;
    public static final double CUP_UK_TO_MILLILITER = 284.13063;
    public static final double CUP_UK_TO_PINT_UK = 0.5;
    public static final double CUP_UK_TO_PINT_US_DRY = 0.51603;
    public static final double CUP_UK_TO_PINT_US = 0.60048;
    public static final double CUP_UK_TO_QUART_UK = 0.25;
    public static final double CUP_UK_TO_QUART_US_DRY = 0.25801;
    public static final double CUP_UK_TO_QUART_US = 0.30024;
    public static final double CUP_UK_TO_TABLESPOON_EU = 18.94204;
    public static final double CUP_UK_TO_TABLESPOON_UK = 16;
    public static final double CUP_UK_TO_TABLESPOON_US = 19.21520;
    public static final double CUP_UK_TO_TEASPOON_EU = 56.82613;
    public static final double CUP_UK_TO_TEASPOON_UK = 48;
    public static final double CUP_UK_TO_TEASPOON_US = 57.64560;

    public static final double CUP_US_TO_CUP_UK = 0.83267;
    public static final double CUP_US_TO_DECILITER = 2.36588;
    public static final double CUP_US_TO_DESSERTSPOON_EU = 23.65882;
    public static final double CUP_US_TO_DESSERTSPOON_UK = 19.98418;
    public static final double CUP_US_TO_DESSERTSPOON_US = 24;
    public static final double CUP_US_TO_FLUID_OUNCE_UK = 8.32674;
    public static final double CUP_US_TO_FLUID_OUNCE_US = 8;
    public static final double CUP_US_TO_GALLON_UK = 0.052042;
    public static final double CUP_US_TO_GALLON_US_DRY = 0.053710;
    public static final double CUP_US_TO_GALLON_US = 0.0625;
    public static final double CUP_US_TO_LITER = 0.23659;
    public static final double CUP_US_TO_MILLILITER = 236.58824;
    public static final double CUP_US_TO_PINT_UK = 0.41634;
    public static final double CUP_US_TO_PINT_US_DRY = 0.42968;
    public static final double CUP_US_TO_PINT_US = 0.5;
    public static final double CUP_US_TO_QUART_UK = 0.20817;
    public static final double CUP_US_TO_QUART_US_DRY = 0.21484;
    public static final double CUP_US_TO_QUART_US = 0.25;
    public static final double CUP_US_TO_TABLESPOON_EU = 15.77255;
    public static final double CUP_US_TO_TABLESPOON_UK = 13.32279;
    public static final double CUP_US_TO_TABLESPOON_US = 16;
    public static final double CUP_US_TO_TEASPOON_EU = 47.31765;
    public static final double CUP_US_TO_TEASPOON_UK = 39.96836;
    public static final double CUP_US_TO_TEASPOON_US = 48;

    public static final double DECILITER_TO_CUP_UK = 0.35195;
    public static final double DECILITER_TO_CUP_US = 0.42268;
    public static final double DECILITER_TO_DESSERTSPOON_EU = 10;
    public static final double DECILITER_TO_DESSERTSPOON_UK = 8.44682;
    public static final double DECILITER_TO_DESSERTSPOON_US = 10.14421;
    public static final double DECILITER_TO_FLUID_OUNCE_UK = 3.51951;
    public static final double DECILITER_TO_FLUID_OUNCE_US = 3.38140;
    public static final double DECILITER_TO_GALLON_UK = 0.021997;
    public static final double DECILITER_TO_GALLON_US_DRY = 0.022702;
    public static final double DECILITER_TO_GALLON_US = 0.026417;
    public static final double DECILITER_TO_LITER = 0.1;
    public static final double DECILITER_TO_MILLILITER = 100;
    public static final double DECILITER_TO_PINT_UK = 0.17598;
    public static final double DECILITER_TO_PINT_US_DRY = 0.18162;
    public static final double DECILITER_TO_PINT_US = 0.21134;
    public static final double DECILITER_TO_QUART_UK = 0.087988;
    public static final double DECILITER_TO_QUART_US_DRY = 0.090808;
    public static final double DECILITER_TO_QUART_US = 0.10567;
    public static final double DECILITER_TO_TABLESPOON_EU = 6.66667;
    public static final double DECILITER_TO_TABLESPOON_UK = 5.63121;
    public static final double DECILITER_TO_TABLESPOON_US = 6.76280;
    public static final double DECILITER_TO_TEASPOON_EU = 20;
    public static final double DECILITER_TO_TEASPOON_UK = 16.89364;
    public static final double DECILITER_TO_TEASPOON_US = 20.28841;

    public static final double DESSERTSPOON_EU_TO_CUP_UK = 0.035195;
    public static final double DESSERTSPOON_EU_TO_CUP_US = 0.042268;
    public static final double DESSERTSPOON_EU_TO_DECILITER = 0.1;
    public static final double DESSERTSPOON_EU_TO_DESSERTSPOON_UK = 0.84468;
    public static final double DESSERTSPOON_EU_TO_DESSERTSPOON_US = 1.01442;
    public static final double DESSERTSPOON_EU_TO_FLUID_OUNCE_UK = 0.35195;
    public static final double DESSERTSPOON_EU_TO_FLUID_OUNCE_US = 0.33814;
    public static final double DESSERTSPOON_EU_TO_GALLON_UK = 0.0021997;
    public static final double DESSERTSPOON_EU_TO_GALLON_US_DRY = 0.0022702;
    public static final double DESSERTSPOON_EU_TO_GALLON_US = 0.0026417;
    public static final double DESSERTSPOON_EU_TO_LITER = 0.01;
    public static final double DESSERTSPOON_EU_TO_MILLILITER = 10;
    public static final double DESSERTSPOON_EU_TO_PINT_UK = 0.017598;
    public static final double DESSERTSPOON_EU_TO_PINT_US_DRY = 0.018162;
    public static final double DESSERTSPOON_EU_TO_PINT_US = 0.021134;
    public static final double DESSERTSPOON_EU_TO_QUART_UK = 0.0087988;
    public static final double DESSERTSPOON_EU_TO_QUART_US_DRY = 0.0090808;
    public static final double DESSERTSPOON_EU_TO_QUART_US = 0.010567;
    public static final double DESSERTSPOON_EU_TO_TABLESPOON_EU = 0.66667;
    public static final double DESSERTSPOON_EU_TO_TABLESPOON_UK = 0.56312;
    public static final double DESSERTSPOON_EU_TO_TABLESPOON_US = 0.67628;
    public static final double DESSERTSPOON_EU_TO_TEASPOON_EU = 2;
    public static final double DESSERTSPOON_EU_TO_TEASPOON_UK = 1.68936;
    public static final double DESSERTSPOON_EU_TO_TEASPOON_US = 2.02884;

    public static final double DESSERTSPOON_UK_TO_CUP_UK = 0.041667;
    public static final double DESSERTSPOON_UK_TO_CUP_US = 0.050040;
    public static final double DESSERTSPOON_UK_TO_DECILITER = 0.11839;
    public static final double DESSERTSPOON_UK_TO_DESSERTSPOON_EU = 1.184;
    public static final double DESSERTSPOON_UK_TO_DESSERTSPOON_US = 1.20095;
    public static final double DESSERTSPOON_UK_TO_FLUID_OUNCE_UK = 0.41667;
    public static final double DESSERTSPOON_UK_TO_FLUID_OUNCE_US = 0.40032;
    public static final double DESSERTSPOON_UK_TO_GALLON_UK = 0.0026042;
    public static final double DESSERTSPOON_UK_TO_GALLON_US_DRY = 0.0026876;
    public static final double DESSERTSPOON_UK_TO_GALLON_US = 0.0031275;
    public static final double DESSERTSPOON_UK_TO_LITER = 0.011839;
    public static final double DESSERTSPOON_UK_TO_MILLILITER = 11.83878;
    public static final double DESSERTSPOON_UK_TO_PINT_UK = 0.020833;
    public static final double DESSERTSPOON_UK_TO_PINT_US_DRY = 0.021501;
    public static final double DESSERTSPOON_UK_TO_PINT_US = 0.025020;
    public static final double DESSERTSPOON_UK_TO_QUART_UK = 0.010417;
    public static final double DESSERTSPOON_UK_TO_QUART_US_DRY = 0.010751;
    public static final double DESSERTSPOON_UK_TO_QUART_US = 0.012510;
    public static final double DESSERTSPOON_UK_TO_TABLESPOON_EU = 0.78925;
    public static final double DESSERTSPOON_UK_TO_TABLESPOON_UK = 0.66667;
    public static final double DESSERTSPOON_UK_TO_TABLESPOON_US = 0.80063;
    public static final double DESSERTSPOON_UK_TO_TEASPOON_EU = 2.36776;
    public static final double DESSERTSPOON_UK_TO_TEASPOON_UK = 2;
    public static final double DESSERTSPOON_UK_TO_TEASPOON_US = 2.40190;

    public static final double DESSERTSPOON_US_TO_CUP_UK = 0.034695;
    public static final double DESSERTSPOON_US_TO_CUP_US = 0.041667;
    public static final double DESSERTSPOON_US_TO_DECILITER = 0.098578;
    public static final double DESSERTSPOON_US_TO_DESSERTSPOON_EU = 0.98578;
    public static final double DESSERTSPOON_US_TO_DESSERTSPOON_UK = 0.83267;
    public static final double DESSERTSPOON_US_TO_FLUID_OUNCE_UK = 0.34695;
    public static final double DESSERTSPOON_US_TO_FLUID_OUNCE_US = 0.33333;
    public static final double DESSERTSPOON_US_TO_GALLON_UK = 0.0021684;
    public static final double DESSERTSPOON_US_TO_GALLON_US_DRY = 0.0022379;
    public static final double DESSERTSPOON_US_TO_GALLON_US = 0.0026042;
    public static final double DESSERTSPOON_US_TO_LITER = 0.0098578;
    public static final double DESSERTSPOON_US_TO_MILLILITER = 9.85784;
    public static final double DESSERTSPOON_US_TO_PINT_UK = 0.017347;
    public static final double DESSERTSPOON_US_TO_PINT_US_DRY = 0.017903;
    public static final double DESSERTSPOON_US_TO_PINT_US = 0.020833;
    public static final double DESSERTSPOON_US_TO_QUART_UK = 0.0086737;
    public static final double DESSERTSPOON_US_TO_QUART_US_DRY = 0.0089517;
    public static final double DESSERTSPOON_US_TO_QUART_US = 0.010417;
    public static final double DESSERTSPOON_US_TO_TABLESPOON_EU = 0.65719;
    public static final double DESSERTSPOON_US_TO_TABLESPOON_UK = 0.55512;
    public static final double DESSERTSPOON_US_TO_TABLESPOON_US = 0.66667;
    public static final double DESSERTSPOON_US_TO_TEASPOON_EU = 1.97157;
    public static final double DESSERTSPOON_US_TO_TEASPOON_UK = 1.66535;
    public static final double DESSERTSPOON_US_TO_TEASPOON_US = 2;

    public static final double FLUID_OUNCE_UK_TO_CUP_UK = 0.1;
    public static final double FLUID_OUNCE_UK_TO_CUP_US = 0.12009;
    public static final double FLUID_OUNCE_UK_TO_DECILITER = 0.28413;
    public static final double FLUID_OUNCE_UK_TO_DESSERTSPOON_EU = 2.84131;
    public static final double FLUID_OUNCE_UK_TO_DESSERTSPOON_UK = 2.4;
    public static final double FLUID_OUNCE_UK_TO_DESSERTSPOON_US = 2.88228;
    public static final double FLUID_OUNCE_UK_TO_FLUID_OUNCE_US = 0.96076;
    public static final double FLUID_OUNCE_UK_TO_GALLON_UK = 0.00625;
    public static final double FLUID_OUNCE_UK_TO_GALLON_US_DRY = 0.0064504;
    public static final double FLUID_OUNCE_UK_TO_GALLON_US = 0.0075059;
    public static final double FLUID_OUNCE_UK_TO_LITER = 0.028413;
    public static final double FLUID_OUNCE_UK_TO_MILLILITER = 28.41306;
    public static final double FLUID_OUNCE_UK_TO_PINT_UK = 0.05;
    public static final double FLUID_OUNCE_UK_TO_PINT_US_DRY = 0.051603;
    public static final double FLUID_OUNCE_UK_TO_PINT_US = 0.060047;
    public static final double FLUID_OUNCE_UK_TO_QUART_UK = 0.025;
    public static final double FLUID_OUNCE_UK_TO_QUART_US_DRY = 0.025801;
    public static final double FLUID_OUNCE_UK_TO_QUART_US = 0.030024;
    public static final double FLUID_OUNCE_UK_TO_TABLESPOON_EU = 1.89420;
    public static final double FLUID_OUNCE_UK_TO_TABLESPOON_UK = 1.6;
    public static final double FLUID_OUNCE_UK_TO_TABLESPOON_US = 1.92152;
    public static final double FLUID_OUNCE_UK_TO_TEASPOON_EU = 5.68261;
    public static final double FLUID_OUNCE_UK_TO_TEASPOON_UK = 4.8;
    public static final double FLUID_OUNCE_UK_TO_TEASPOON_US = 5.76456;

    public static final double FLUID_OUNCE_US_TO_CUP_UK = 0.10408;
    public static final double FLUID_OUNCE_US_TO_CUP_US = 0.125;
    public static final double FLUID_OUNCE_US_TO_DECILITER = 0.29574;
    public static final double FLUID_OUNCE_US_TO_DESSERTSPOON_EU = 2.95735;
    public static final double FLUID_OUNCE_US_TO_DESSERTSPOON_UK = 2.49802;
    public static final double FLUID_OUNCE_US_TO_DESSERTSPOON_US = 3;
    public static final double FLUID_OUNCE_US_TO_FLUID_OUNCE_UK = 1.04084;
    public static final double FLUID_OUNCE_US_TO_GALLON_UK = 0.0065053;
    public static final double FLUID_OUNCE_US_TO_GALLON_US_DRY = 0.0067138;
    public static final double FLUID_OUNCE_US_TO_GALLON_US = 0.0078125;
    public static final double FLUID_OUNCE_US_TO_LITER = 0.029574;
    public static final double FLUID_OUNCE_US_TO_MILLILITER = 29.57353;
    public static final double FLUID_OUNCE_US_TO_PINT_UK = 0.052042;
    public static final double FLUID_OUNCE_US_TO_PINT_US_DRY = 0.053710;
    public static final double FLUID_OUNCE_US_TO_PINT_US = 0.0625;
    public static final double FLUID_OUNCE_US_TO_QUART_UK = 0.026021;
    public static final double FLUID_OUNCE_US_TO_QUART_US_DRY = 0.026855;
    public static final double FLUID_OUNCE_US_TO_QUART_US = 0.03125;
    public static final double FLUID_OUNCE_US_TO_TABLESPOON_EU = 1.97157;
    public static final double FLUID_OUNCE_US_TO_TABLESPOON_UK = 1.66535;
    public static final double FLUID_OUNCE_US_TO_TABLESPOON_US = 2;
    public static final double FLUID_OUNCE_US_TO_TEASPOON_EU = 5.91471;
    public static final double FLUID_OUNCE_US_TO_TEASPOON_UK = 4.99605;
    public static final double FLUID_OUNCE_US_TO_TEASPOON_US = 6;

    public static final double GALLON_UK_TO_CUP_UK = 16;
    public static final double GALLON_UK_TO_CUP_US = 19.21520;
    public static final double GALLON_UK_TO_DECILITER = 45.4609;
    public static final double GALLON_UK_TO_DESSERTSPOON_EU = 454.609;
    public static final double GALLON_UK_TO_DESSERTSPOON_UK = 384;
    public static final double GALLON_UK_TO_DESSERTSPOON_US = 461.16477;
    public static final double GALLON_UK_TO_FLUID_OUNCE_UK = 160;
    public static final double GALLON_UK_TO_FLUID_OUNCE_US = 153.72159;
    public static final double GALLON_UK_TO_GALLON_US_DRY = 1.03206;
    public static final double GALLON_UK_TO_GALLON_US = 1.20095;
    public static final double GALLON_UK_TO_LITER = 4.54609;
    public static final double GALLON_UK_TO_MILLILITER = 4546.09;
    public static final double GALLON_UK_TO_PINT_UK = 8;
    public static final double GALLON_UK_TO_PINT_US_DRY = 8.25645;
    public static final double GALLON_UK_TO_PINT_US = 9.60760;
    public static final double GALLON_UK_TO_QUART_UK = 4;
    public static final double GALLON_UK_TO_QUART_US_DRY = 4.12823;
    public static final double GALLON_UK_TO_QUART_US = 4.80380;
    public static final double GALLON_UK_TO_TABLESPOON_EU = 303.07267;
    public static final double GALLON_UK_TO_TABLESPOON_UK = 256;
    public static final double GALLON_UK_TO_TABLESPOON_US = 307.44318;
    public static final double GALLON_UK_TO_TEASPOON_EU = 909.218;
    public static final double GALLON_UK_TO_TEASPOON_UK = 768;
    public static final double GALLON_UK_TO_TEASPOON_US = 922.32954;

    public static final double GALLON_US_DRY_TO_CUP_UK = 15.50302;
    public static final double GALLON_US_DRY_TO_CUP_US = 18.61836;
    public static final double GALLON_US_DRY_TO_DECILITER = 44.04884;
    public static final double GALLON_US_DRY_TO_DESSERTSPOON_EU = 440.48838;
    public static final double GALLON_US_DRY_TO_DESSERTSPOON_UK = 372.07257;
    public static final double GALLON_US_DRY_TO_DESSERTSPOON_US = 446.84052;
    public static final double GALLON_US_DRY_TO_FLUID_OUNCE_UK = 155.03024;
    public static final double GALLON_US_DRY_TO_FLUID_OUNCE_US = 148.94684;
    public static final double GALLON_US_DRY_TO_GALLON_UK = 0.96894;
    public static final double GALLON_US_DRY_TO_GALLON_US = 1.16365;
    public static final double GALLON_US_DRY_TO_LITER = 4.40488;
    public static final double GALLON_US_DRY_TO_MILLILITER = 4404.8838;
    public static final double GALLON_US_DRY_TO_PINT_UK = 7.75151;
    public static final double GALLON_US_DRY_TO_PINT_US_DRY = 8;
    public static final double GALLON_US_DRY_TO_PINT_US = 9.30918;
    public static final double GALLON_US_DRY_TO_QUART_UK = 3.87576;
    public static final double GALLON_US_DRY_TO_QUART_US_DRY = 4;
    public static final double GALLON_US_DRY_TO_QUART_US = 4.65459;
    public static final double GALLON_US_DRY_TO_TABLESPOON_EU = 293.65892;
    public static final double GALLON_US_DRY_TO_TABLESPOON_UK = 248.04838;
    public static final double GALLON_US_DRY_TO_TABLESPOON_US = 297.89368;
    public static final double GALLON_US_DRY_TO_TEASPOON_EU = 880.97676;
    public static final double GALLON_US_DRY_TO_TEASPOON_UK = 744.14513;
    public static final double GALLON_US_DRY_TO_TEASPOON_US = 893.68104;

    public static final double GALLON_US_TO_CUP_UK = 13.32279;
    public static final double GALLON_US_TO_CUP_US = 16;
    public static final double GALLON_US_TO_DECILITER = 37.85412;
    public static final double GALLON_US_TO_DESSERTSPOON_EU = 378.54418;
    public static final double GALLON_US_TO_DESSERTSPOON_UK = 319.74689;
    public static final double GALLON_US_TO_DESSERTSPOON_US = 384;
    public static final double GALLON_US_TO_FLUID_OUNCE_UK = 133.22787;
    public static final double GALLON_US_TO_FLUID_OUNCE_US = 128;
    public static final double GALLON_US_TO_GALLON_UK = 0.83267;
    public static final double GALLON_US_TO_GALLON_US_DRY = 0.85937;
    public static final double GALLON_US_TO_LITER = 3.78541;
    public static final double GALLON_US_TO_MILLILITER = 3785.41178;
    public static final double GALLON_US_TO_PINT_UK = 6.66139;
    public static final double GALLON_US_TO_PINT_US_DRY = 6.87494;
    public static final double GALLON_US_TO_PINT_US = 8;
    public static final double GALLON_US_TO_QUART_UK = 3.33070;
    public static final double GALLON_US_TO_QUART_US_DRY = 3.43747;
    public static final double GALLON_US_TO_QUART_US = 4;
    public static final double GALLON_US_TO_TABLESPOON_EU = 252.36079;
    public static final double GALLON_US_TO_TABLESPOON_UK = 213.16459;
    public static final double GALLON_US_TO_TABLESPOON_US = 256;
    public static final double GALLON_US_TO_TEASPOON_EU = 757.08236;
    public static final double GALLON_US_TO_TEASPOON_UK = 639.49378;
    public static final double GALLON_US_TO_TEASPOON_US = 768;

    public static final double LITER_TO_CUP_UK = 3.51951;
    public static final double LITER_TO_CUP_US = 4.22675;
    public static final double LITER_TO_DECILITER = 10;
    public static final double LITER_TO_DESSERTSPOON_EU = 100;
    public static final double LITER_TO_DESSERTSPOON_UK = 84.46819;
    public static final double LITER_TO_DESSERTSPOON_US = 101.44207;
    public static final double LITER_TO_FLUID_OUNCE_UK = 35.19508;
    public static final double LITER_TO_FLUID_OUNCE_US = 33.81402;
    public static final double LITER_TO_GALLON_UK = 0.21997;
    public static final double LITER_TO_GALLON_US_DRY = 0.22702;
    public static final double LITER_TO_GALLON_US = 0.26417;
    public static final double LITER_TO_MILLILITER = 1000;
    public static final double LITER_TO_PINT_UK = 1.75975;
    public static final double LITER_TO_PINT_US_DRY = 1.81617;
    public static final double LITER_TO_PINT_US = 2.11338;
    public static final double LITER_TO_QUART_UK = 0.87988;
    public static final double LITER_TO_QUART_US_DRY = 0.90808;
    public static final double LITER_TO_QUART_US = 1.05669;
    public static final double LITER_TO_TABLESPOON_EU = 66.66667;
    public static final double LITER_TO_TABLESPOON_UK = 56.31213;
    public static final double LITER_TO_TABLESPOON_US = 67.62805;
    public static final double LITER_TO_TEASPOON_EU = 200;
    public static final double LITER_TO_TEASPOON_UK = 168.93638;
    public static final double LITER_TO_TEASPOON_US = 202.88414;

    public static final double MILLILITER_TO_CUP_UK = 0.0035195;
    public static final double MILLILITER_TO_CUP_US = 0.0042268;
    public static final double MILLILITER_TO_DECILITER = 0.01;
    public static final double MILLILITER_TO_DESSERTSPOON_EU = 0.1;
    public static final double MILLILITER_TO_DESSERTSPOON_UK = 0.084468;
    public static final double MILLILITER_TO_DESSERTSPOON_US = 0.10144;
    public static final double MILLILITER_TO_FLUID_OUNCE_UK = 0.035195;
    public static final double MILLILITER_TO_FLUID_OUNCE_US = 0.033814;
    public static final double MILLILITER_TO_GALLON_UK = 0.00021997;
    public static final double MILLILITER_TO_GALLON_US_DRY = 0.00022702;
    public static final double MILLILITER_TO_GALLON_US = 0.00026417;
    public static final double MILLILITER_TO_LITER = 0.001;
    public static final double MILLILITER_TO_PINT_UK = 0.0017598;
    public static final double MILLILITER_TO_PINT_US_DRY = 0.0018162;
    public static final double MILLILITER_TO_PINT_US = 0.0021134;
    public static final double MILLILITER_TO_QUART_UK = 0.00087988;
    public static final double MILLILITER_TO_QUART_US_DRY = 0.00090808;
    public static final double MILLILITER_TO_QUART_US = 0.0010567;
    public static final double MILLILITER_TO_TABLESPOON_EU = 0.066667;
    public static final double MILLILITER_TO_TABLESPOON_UK = 0.056312;
    public static final double MILLILITER_TO_TABLESPOON_US = 0.067628;
    public static final double MILLILITER_TO_TEASPOON_EU = 0.2;
    public static final double MILLILITER_TO_TEASPOON_UK = 0.16894;
    public static final double MILLILITER_TO_TEASPOON_US = 0.20288;

    public static final double PINT_UK_TO_CUP_UK = 2;
    public static final double PINT_UK_TO_CUP_US = 2.40190;
    public static final double PINT_UK_TO_DECILITER = 5.68261;
    public static final double PINT_UK_TO_DESSERTSPOON_EU = 56.82613;
    public static final double PINT_UK_TO_DESSERTSPOON_UK = 48;
    public static final double PINT_UK_TO_DESSERTSPOON_US = 57.64560;
    public static final double PINT_UK_TO_FLUID_OUNCE_UK = 20;
    public static final double PINT_UK_TO_FLUID_OUNCE_US = 19.21520;
    public static final double PINT_UK_TO_GALLON_UK = 0.125;
    public static final double PINT_UK_TO_GALLON_US_DRY = 0.12901;
    public static final double PINT_UK_TO_GALLON_US = 0.15012;
    public static final double PINT_UK_TO_LITER = 0.56826;
    public static final double PINT_UK_TO_MILLILITER = 568.26125;
    public static final double PINT_UK_TO_PINT_US_DRY = 1.03206;
    public static final double PINT_UK_TO_PINT_US = 1.20095;
    public static final double PINT_UK_TO_QUART_UK = 0.5;
    public static final double PINT_UK_TO_QUART_US_DRY = 0.51603;
    public static final double PINT_UK_TO_QUART_US = 0.60047;
    public static final double PINT_UK_TO_TABLESPOON_EU = 37.88408;
    public static final double PINT_UK_TO_TABLESPOON_UK = 32;
    public static final double PINT_UK_TO_TABLESPOON_US = 38.43040;
    public static final double PINT_UK_TO_TEASPOON_EU = 113.65225;
    public static final double PINT_UK_TO_TEASPOON_UK = 96;
    public static final double PINT_UK_TO_TEASPOON_US = 115.29119;

    public static final double PINT_US_DRY_TO_CUP_UK = 1.93788;
    public static final double PINT_US_DRY_TO_CUP_US = 2.32729;
    public static final double PINT_US_DRY_TO_DECILITER = 5.50610;
    public static final double PINT_US_DRY_TO_DESSERTSPOON_EU = 55.06105;
    public static final double PINT_US_DRY_TO_DESSERTSPOON_UK = 46.50907;
    public static final double PINT_US_DRY_TO_DESSERTSPOON_US = 55.85507;
    public static final double PINT_US_DRY_TO_FLUID_OUNCE_UK = 19.37878;
    public static final double PINT_US_DRY_TO_FLUID_OUNCE_US = 18.61836;
    public static final double PINT_US_DRY_TO_GALLON_UK = 0.12112;
    public static final double PINT_US_DRY_TO_GALLON_US_DRY = 0.125;
    public static final double PINT_US_DRY_TO_GALLON_US = 0.14546;
    public static final double PINT_US_DRY_TO_LITER = 0.55061;
    public static final double PINT_US_DRY_TO_MILLILITER = 550.61047;
    public static final double PINT_US_DRY_TO_PINT_UK = 0.96894;
    public static final double PINT_US_DRY_TO_PINT_US = 1.16365;
    public static final double PINT_US_DRY_TO_QUART_UK = 0.48447;
    public static final double PINT_US_DRY_TO_QUART_US_DRY = 0.5;
    public static final double PINT_US_DRY_TO_QUART_US = 0.58182;
    public static final double PINT_US_DRY_TO_TABLESPOON_EU = 36.70736;
    public static final double PINT_US_DRY_TO_TABLESPOON_UK = 31.00605;
    public static final double PINT_US_DRY_TO_TABLESPOON_US = 37.23671;
    public static final double PINT_US_DRY_TO_TEASPOON_EU = 110.12209;
    public static final double PINT_US_DRY_TO_TEASPOON_UK = 93.01814;
    public static final double PINT_US_DRY_TO_TEASPOON_US = 111.71013;

    public static final double PINT_US_TO_CUP_UK = 1.66535;
    public static final double PINT_US_TO_CUP_US = 2;
    public static final double PINT_US_TO_DECILITER = 4.73176;
    public static final double PINT_US_TO_DESSERTSPOON_EU = 47.31765;
    public static final double PINT_US_TO_DESSERTSPOON_UK = 39.96836;
    public static final double PINT_US_TO_DESSERTSPOON_US = 48;
    public static final double PINT_US_TO_FLUID_OUNCE_UK = 16.65348;
    public static final double PINT_US_TO_FLUID_OUNCE_US = 16;
    public static final double PINT_US_TO_GALLON_UK = 0.10408;
    public static final double PINT_US_TO_GALLON_US_DRY = 0.10742;
    public static final double PINT_US_TO_GALLON_US = 0.125;
    public static final double PINT_US_TO_LITER = 0.47318;
    public static final double PINT_US_TO_MILLILITER = 473.17647;
    public static final double PINT_US_TO_PINT_US_DRY = 0.85937;
    public static final double PINT_US_TO_PINT_UK = 0.83267;
    public static final double PINT_US_TO_QUART_UK = 0.41634;
    public static final double PINT_US_TO_QUART_US_DRY = 0.42968;
    public static final double PINT_US_TO_QUART_US = 0.5;
    public static final double PINT_US_TO_TABLESPOON_EU = 31.54510;
    public static final double PINT_US_TO_TABLESPOON_UK = 26.64557;
    public static final double PINT_US_TO_TABLESPOON_US = 32;
    public static final double PINT_US_TO_TEASPOON_EU = 94.63529;
    public static final double PINT_US_TO_TEASPOON_UK = 79.93672;
    public static final double PINT_US_TO_TEASPOON_US = 96;

    public static final double QUART_UK_TO_CUP_UK = 4;
    public static final double QUART_UK_TO_CUP_US = 4.80380;
    public static final double QUART_UK_TO_DECILITER = 11.36523;
    public static final double QUART_UK_TO_DESSERTSPOON_EU = 113.65225;
    public static final double QUART_UK_TO_DESSERTSPOON_UK = 96;
    public static final double QUART_UK_TO_DESSERTSPOON_US = 115.29119;
    public static final double QUART_UK_TO_FLUID_OUNCE_UK = 40;
    public static final double QUART_UK_TO_FLUID_OUNCE_US = 38.43040;
    public static final double QUART_UK_TO_GALLON_UK = 0.25;
    public static final double QUART_UK_TO_GALLON_US_DRY = 0.25801;
    public static final double QUART_UK_TO_GALLON_US = 0.30024;
    public static final double QUART_UK_TO_LITER = 1.13652;
    public static final double QUART_UK_TO_MILLILITER = 1136.5225;
    public static final double QUART_UK_TO_PINT_UK = 2;
    public static final double QUART_UK_TO_PINT_US_DRY = 2.064113;
    public static final double QUART_UK_TO_PINT_US = 2.40190;
    public static final double QUART_UK_TO_QUART_US_DRY = 1.03206;
    public static final double QUART_UK_TO_QUART_US = 1.20095;
    public static final double QUART_UK_TO_TABLESPOON_EU = 75.76817;
    public static final double QUART_UK_TO_TABLESPOON_UK = 64;
    public static final double QUART_UK_TO_TABLESPOON_US = 76.86080;
    public static final double QUART_UK_TO_TEASPOON_EU = 227.3045;
    public static final double QUART_UK_TO_TEASPOON_UK = 192;
    public static final double QUART_UK_TO_TEASPOON_US = 230.58239;

    public static final double QUART_US_DRY_TO_CUP_UK = 3.87576;
    public static final double QUART_US_DRY_TO_CUP_US = 4.65459;
    public static final double QUART_US_DRY_TO_DECILITER = 11.01221;
    public static final double QUART_US_DRY_TO_DESSERTSPOON_EU = 110.12210;
    public static final double QUART_US_DRY_TO_DESSERTSPOON_UK = 93.01814;
    public static final double QUART_US_DRY_TO_DESSERTSPOON_US = 111.71013;
    public static final double QUART_US_DRY_TO_FLUID_OUNCE_UK = 38.75756;
    public static final double QUART_US_DRY_TO_FLUID_OUNCE_US = 37.23671;
    public static final double QUART_US_DRY_TO_GALLON_UK = 0.24223;
    public static final double QUART_US_DRY_TO_GALLON_US_DRY = 0.25;
    public static final double QUART_US_DRY_TO_GALLON_US = 0.29091;
    public static final double QUART_US_DRY_TO_LITER = 1.10122;
    public static final double QUART_US_DRY_TO_MILLILITER = 1101.22095;
    public static final double QUART_US_DRY_TO_PINT_UK = 1.93788;
    public static final double QUART_US_DRY_TO_PINT_US_DRY = 2;
    public static final double QUART_US_DRY_TO_PINT_US = 2.32729;
    public static final double QUART_US_DRY_TO_QUART_UK = 0.96894;
    public static final double QUART_US_DRY_TO_QUART_US = 1.16365;
    public static final double QUART_US_DRY_TO_TABLESPOON_EU = 73.41473;
    public static final double QUART_US_DRY_TO_TABLESPOON_UK = 62.01209;
    public static final double QUART_US_DRY_TO_TABLESPOON_US = 74.47342;
    public static final double QUART_US_DRY_TO_TEASPOON_EU = 220.24419;
    public static final double QUART_US_DRY_TO_TEASPOON_UK = 186.03628;
    public static final double QUART_US_DRY_TO_TEASPOON_US = 223.42026;

    public static final double QUART_US_TO_CUP_UK = 3.33070;
    public static final double QUART_US_TO_CUP_US = 4;
    public static final double QUART_US_TO_DECILITER = 9.46353;
    public static final double QUART_US_TO_DESSERTSPOON_EU = 94.63530;
    public static final double QUART_US_TO_DESSERTSPOON_UK = 79.93672;
    public static final double QUART_US_TO_DESSERTSPOON_US = 96;
    public static final double QUART_US_TO_FLUID_OUNCE_UK = 33.30697;
    public static final double QUART_US_TO_FLUID_OUNCE_US = 32;
    public static final double QUART_US_TO_GALLON_UK = 0.20817;
    public static final double QUART_US_TO_GALLON_US_DRY = 0.21484;
    public static final double QUART_US_TO_GALLON_US = 0.25;
    public static final double QUART_US_TO_LITER = 0.94635;
    public static final double QUART_US_TO_MILLILITER = 946.35295;
    public static final double QUART_US_TO_PINT_UK = 1.66535;
    public static final double QUART_US_TO_PINT_US_DRY = 1.71873;
    public static final double QUART_US_TO_PINT_US = 2;
    public static final double QUART_US_TO_QUART_UK = 0.83267;
    public static final double QUART_US_TO_QUART_US_DRY = 0.85937;
    public static final double QUART_US_TO_TABLESPOON_EU = 63.09010;
    public static final double QUART_US_TO_TABLESPOON_UK = 53.29115;
    public static final double QUART_US_TO_TABLESPOON_US = 64;
    public static final double QUART_US_TO_TEASPOON_EU = 189.27059;
    public static final double QUART_US_TO_TEASPOON_UK = 159.87344;
    public static final double QUART_US_TO_TEASPOON_US = 192;

    public static final double TABLESPOON_EU_TO_CUP_UK = 0.052793;
    public static final double TABLESPOON_EU_TO_CUP_US = 0.063401;
    public static final double TABLESPOON_EU_TO_DECILITER = 0.15;
    public static final double TABLESPOON_EU_TO_DESSERTSPOON_EU = 1.5;
    public static final double TABLESPOON_EU_TO_DESSERTSPOON_UK = 1.26702;
    public static final double TABLESPOON_EU_TO_DESSERTSPOON_US = 1.52163;
    public static final double TABLESPOON_EU_TO_FLUID_OUNCE_UK = 0.52793;
    public static final double TABLESPOON_EU_TO_FLUID_OUNCE_US = 0.50721;
    public static final double TABLESPOON_EU_TO_GALLON_UK = 0.0032995;
    public static final double TABLESPOON_EU_TO_GALLON_US_DRY = 0.0034053;
    public static final double TABLESPOON_EU_TO_GALLON_US = 0.0039626;
    public static final double TABLESPOON_EU_TO_LITER = 0.015;
    public static final double TABLESPOON_EU_TO_MILLILITER = 15;
    public static final double TABLESPOON_EU_TO_PINT_UK = 0.026396;
    public static final double TABLESPOON_EU_TO_PINT_US_DRY = 0.027242;
    public static final double TABLESPOON_EU_TO_PINT_US = 0.031701;
    public static final double TABLESPOON_EU_TO_QUART_UK = 0.013198;
    public static final double TABLESPOON_EU_TO_QUART_US_DRY = 0.013621;
    public static final double TABLESPOON_EU_TO_QUART_US = 0.015850;
    public static final double TABLESPOON_EU_TO_TABLESPOON_UK = 0.84468;
    public static final double TABLESPOON_EU_TO_TABLESPOON_US = 1.01442;
    public static final double TABLESPOON_EU_TO_TEASPOON_EU = 3;
    public static final double TABLESPOON_EU_TO_TEASPOON_UK = 2.53405;
    public static final double TABLESPOON_EU_TO_TEASPOON_US = 3.04326;

    public static final double TABLESPOON_UK_TO_CUP_UK = 0.0625;
    public static final double TABLESPOON_UK_TO_CUP_US = 0.075059;
    public static final double TABLESPOON_UK_TO_DECILITER = 0.17758;
    public static final double TABLESPOON_UK_TO_DESSERTSPOON_EU = 1.77582;
    public static final double TABLESPOON_UK_TO_DESSERTSPOON_UK = 1.5;
    public static final double TABLESPOON_UK_TO_DESSERTSPOON_US = 1.80142;
    public static final double TABLESPOON_UK_TO_FLUID_OUNCE_UK = 0.625;
    public static final double TABLESPOON_UK_TO_FLUID_OUNCE_US = 0.60047;
    public static final double TABLESPOON_UK_TO_GALLON_UK = 0.0039063;
    public static final double TABLESPOON_UK_TO_GALLON_US_DRY = 0.0046912;
    public static final double TABLESPOON_UK_TO_GALLON_US = 0.0040315;
    public static final double TABLESPOON_UK_TO_LITER = 0.017758;
    public static final double TABLESPOON_UK_TO_MILLILITER = 17.75816;
    public static final double TABLESPOON_UK_TO_PINT_UK = 0.03125;
    public static final double TABLESPOON_UK_TO_PINT_US_DRY = 0.032252;
    public static final double TABLESPOON_UK_TO_PINT_US = 0.037530;
    public static final double TABLESPOON_UK_TO_QUART_UK = 0.015625;
    public static final double TABLESPOON_UK_TO_QUART_US_DRY = 0.016126;
    public static final double TABLESPOON_UK_TO_QUART_US = 0.018765;
    public static final double TABLESPOON_UK_TO_TABLESPOON_EU = 1.18388;
    public static final double TABLESPOON_UK_TO_TABLESPOON_US = 1.20095;
    public static final double TABLESPOON_UK_TO_TEASPOON_EU = 3.55163;
    public static final double TABLESPOON_UK_TO_TEASPOON_UK = 3;
    public static final double TABLESPOON_UK_TO_TEASPOON_US = 3.60285;

    public static final double TABLESPOON_US_TO_CUP_UK = 0.052042;
    public static final double TABLESPOON_US_TO_CUP_US = 0.0625;
    public static final double TABLESPOON_US_TO_DECILITER = 0.14787;
    public static final double TABLESPOON_US_TO_DESSERTSPOON_EU = 1.47868;
    public static final double TABLESPOON_US_TO_DESSERTSPOON_UK = 1.24901;
    public static final double TABLESPOON_US_TO_DESSERTSPOON_US = 1.5;
    public static final double TABLESPOON_US_TO_FLUID_OUNCE_UK = 0.52042;
    public static final double TABLESPOON_US_TO_FLUID_OUNCE_US = 0.5;
    public static final double TABLESPOON_US_TO_GALLON_UK = 0.0032526;
    public static final double TABLESPOON_US_TO_GALLON_US_DRY = 0.0033569;
    public static final double TABLESPOON_US_TO_GALLON_US = 0.0039063;
    public static final double TABLESPOON_US_TO_LITER = 0.014787;
    public static final double TABLESPOON_US_TO_MILLILITER = 14.78676;
    public static final double TABLESPOON_US_TO_PINT_UK = 0.026021;
    public static final double TABLESPOON_US_TO_PINT_US_DRY = 0.026855;
    public static final double TABLESPOON_US_TO_PINT_US = 0.03125;
    public static final double TABLESPOON_US_TO_QUART_UK = 0.013011;
    public static final double TABLESPOON_US_TO_QUART_US_DRY = 0.013428;
    public static final double TABLESPOON_US_TO_QUART_US = 0.015625;
    public static final double TABLESPOON_US_TO_TABLESPOON_EU = 0.98578;
    public static final double TABLESPOON_US_TO_TABLESPOON_UK = 0.83267;
    public static final double TABLESPOON_US_TO_TEASPOON_EU = 2.95735;
    public static final double TABLESPOON_US_TO_TEASPOON_UK = 2.49802;
    public static final double TABLESPOON_US_TO_TEASPOON_US = 3;

    public static final double TEASPOON_EU_TO_CUP_UK = 0.017598;
    public static final double TEASPOON_EU_TO_CUP_US = 0.021134;
    public static final double TEASPOON_EU_TO_DECILITER = 0.05;
    public static final double TEASPOON_EU_TO_DESSERTSPOON_EU = 0.5;
    public static final double TEASPOON_EU_TO_DESSERTSPOON_UK = 0.42234;
    public static final double TEASPOON_EU_TO_DESSERTSPOON_US = 0.50721;
    public static final double TEASPOON_EU_TO_FLUID_OUNCE_UK = 0.17598;
    public static final double TEASPOON_EU_TO_FLUID_OUNCE_US = 0.16907;
    public static final double TEASPOON_EU_TO_GALLON_UK = 0.0010998;
    public static final double TEASPOON_EU_TO_GALLON_US_DRY = 0.0011351;
    public static final double TEASPOON_EU_TO_GALLON_US = 0.0013209;
    public static final double TEASPOON_EU_TO_LITER = 0.005;
    public static final double TEASPOON_EU_TO_MILLILITER = 5;
    public static final double TEASPOON_EU_TO_PINT_UK = 0.0087988;
    public static final double TEASPOON_EU_TO_PINT_US_DRY = 0.0090808;
    public static final double TEASPOON_EU_TO_PINT_US = 0.010567;
    public static final double TEASPOON_EU_TO_QUART_UK = 0.0043994;
    public static final double TEASPOON_EU_TO_QUART_US_DRY = 0.0045404;
    public static final double TEASPOON_EU_TO_QUART_US = 0.0052834;
    public static final double TEASPOON_EU_TO_TABLESPOON_EU = 0.33333;
    public static final double TEASPOON_EU_TO_TABLESPOON_UK = 0.28156;
    public static final double TEASPOON_EU_TO_TABLESPOON_US = 0.33814;
    public static final double TEASPOON_EU_TO_TEASPOON_UK = 0.84468;
    public static final double TEASPOON_EU_TO_TEASPOON_US = 1.01442;

    public static final double TEASPOON_UK_TO_CUP_UK = 0.020833;
    public static final double TEASPOON_UK_TO_CUP_US = 0.02502;
    public static final double TEASPOON_UK_TO_DECILITER = 0.059194;
    public static final double TEASPOON_UK_TO_DESSERTSPOON_EU = 0.59194;
    public static final double TEASPOON_UK_TO_DESSERTSPOON_UK = 0.5;
    public static final double TEASPOON_UK_TO_DESSERTSPOON_US = 0.60047;
    public static final double TEASPOON_UK_TO_FLUID_OUNCE_UK = 0.20833;
    public static final double TEASPOON_UK_TO_FLUID_OUNCE_US = 0.20016;
    public static final double TEASPOON_UK_TO_GALLON_UK = 0.0013021;
    public static final double TEASPOON_UK_TO_GALLON_US_DRY = 0.0013438;
    public static final double TEASPOON_UK_TO_GALLON_US = 0.0015637;
    public static final double TEASPOON_UK_TO_LITER = 0.0059194;
    public static final double TEASPOON_UK_TO_MILLILITER = 5.91939;
    public static final double TEASPOON_UK_TO_PINT_UK = 0.010417;
    public static final double TEASPOON_UK_TO_PINT_US_DRY = 0.010751;
    public static final double TEASPOON_UK_TO_PINT_US = 0.01251;
    public static final double TEASPOON_UK_TO_QUART_UK = 0.0052083;
    public static final double TEASPOON_UK_TO_QUART_US_DRY = 0.0053753;
    public static final double TEASPOON_UK_TO_QUART_US = 0.006255;
    public static final double TEASPOON_UK_TO_TABLESPOON_EU = 0.39463;
    public static final double TEASPOON_UK_TO_TABLESPOON_UK = 0.33333;
    public static final double TEASPOON_UK_TO_TABLESPOON_US = 0.40032;
    public static final double TEASPOON_UK_TO_TEASPOON_EU = 1.18388;
    public static final double TEASPOON_UK_TO_TEASPOON_US = 1.20095;

    public static final double TEASPOON_US_TO_CUP_UK = 0.017347;
    public static final double TEASPOON_US_TO_CUP_US = 0.020833;
    public static final double TEASPOON_US_TO_DECILITER = 0.049289;
    public static final double TEASPOON_US_TO_DESSERTSPOON_EU = 0.49289;
    public static final double TEASPOON_US_TO_DESSERTSPOON_UK = 0.41634;
    public static final double TEASPOON_US_TO_DESSERTSPOON_US = 0.5;
    public static final double TEASPOON_US_TO_FLUID_OUNCE_UK = 0.17347;
    public static final double TEASPOON_US_TO_FLUID_OUNCE_US = 0.16667;
    public static final double TEASPOON_US_TO_GALLON_UK = 0.0010842;
    public static final double TEASPOON_US_TO_GALLON_US_DRY = 0.0011190;
    public static final double TEASPOON_US_TO_GALLON_US = 0.0013021;
    public static final double TEASPOON_US_TO_LITER = 0.0049289;
    public static final double TEASPOON_US_TO_MILLILITER = 4.92892;
    public static final double TEASPOON_US_TO_PINT_UK = 0.0086737;
    public static final double TEASPOON_US_TO_PINT_US_DRY = 0.0089517;
    public static final double TEASPOON_US_TO_PINT_US = 0.010417;
    public static final double TEASPOON_US_TO_QUART_UK = 0.0043368;
    public static final double TEASPOON_US_TO_QUART_US_DRY = 0.0044759;
    public static final double TEASPOON_US_TO_QUART_US = 0.0052083;
    public static final double TEASPOON_US_TO_TABLESPOON_EU = 0.32859;
    public static final double TEASPOON_US_TO_TABLESPOON_UK = 0.27756;
    public static final double TEASPOON_US_TO_TABLESPOON_US = 0.33333;
    public static final double TEASPOON_US_TO_TEASPOON_EU = 0.98578;
    public static final double TEASPOON_US_TO_TEASPOON_UK = 0.83267;



    //************************************** CONVERT FROM GRAM ****************************************************

    public static double gramToKilogram(double amount){
        return amount*GRAM_TO_KILOGRAM;
    }
    public static double gramToOunce(double amount){
        return amount*GRAM_TO_OUNCE;
    }
    public static double gramToPound(double amount){
        return amount*GRAM_TO_POUND;
    }

    //************************************** CONVERT FROM KILOGRAM ************************************************

    public static double kilogramToGram(double amount){
        return amount*KILOGRAM_TO_GRAM;
    }
    public static double kilogramToOunce(double amount){
        return amount*KILOGRAM_TO_OUNCE;
    }
    public static double kilogramToPound(double amount){
        return amount*KILOGRAM_TO_POUND;
    }

    //************************************** CONVERT FROM OUNCE ***************************************************

    public static double ounceToGram(double amount){
        return amount*OUNCE_TO_GRAM;
    }
    public static double ounceToKilogram(double amount){
        return amount*OUNCE_TO_KILOGRAM;
    }
    public static double ounceToPound(double amount){
        return amount*OUNCE_TO_POUND;
    }

    //************************************** CONVERT FROM POUND ***************************************************

    public static double poundToGram(double amount){
        return amount*POUND_TO_GRAM;
    }
    public static double poundToKilogram(double amount){
        return amount*POUND_TO_KILOGRAM;
    }
    public static double poundToOunce(double amount){
        return amount*POUND_TO_OUNCE;
    }

    //************************************** CONVERT FROM CUP (UK) ************************************************

    public static double cupUKToCupUS(double amount){
        return amount*CUP_UK_TO_CUP_US;
    }
    public static double cupUKToDeciliter(double amount){
        return amount*CUP_UK_TO_DECILITER;
    }
    public static double cupUKToDessertspoonEU(double amount){
        return amount*CUP_UK_TO_DESSERTSPOON_EU;
    }
    public static double cupUKToDessertspoonUK(double amount){
        return amount*CUP_UK_TO_DESSERTSPOON_UK;
    }
    public static double cupUKToDessertspoonUS(double amount){
        return amount*CUP_UK_TO_DESSERTSPOON_US;
    }
    public static double cupUKToFluidOunceUK(double amount){
        return amount*CUP_UK_TO_FLUID_OUNCE_UK;
    }
    public static double cupUKToFluidOunceUS(double amount){
        return amount*CUP_UK_TO_FLUID_OUNCE_US;
    }
    public static double cupUKToGallonUK(double amount){
        return amount*CUP_UK_TO_GALLON_UK;
    }
    public static double cupUKToGallonUSDry(double amount){
        return amount*CUP_UK_TO_GALLON_US_DRY;
    }
    public static double cupUKToGallonUS(double amount){
        return amount*CUP_UK_TO_GALLON_US;
    }
    public static double cupUKToLiter(double amount){
        return amount*CUP_UK_TO_LITER;
    }
    public static double cupUKToMilliliter(double amount){
        return amount*CUP_UK_TO_MILLILITER;
    }
    public static double cupUKToPintUK(double amount){
        return amount*CUP_UK_TO_PINT_UK;
    }
    public static double cupUKToPintUSDry(double amount){
        return amount*CUP_UK_TO_PINT_US_DRY;
    }
    public static double cupUKToPintUS(double amount){
        return amount*CUP_UK_TO_PINT_US;
    }
    public static double cupUKToQuartUK(double amount){
        return amount*CUP_UK_TO_QUART_UK;
    }
    public static double cupUKToQuartUSDry(double amount){
        return amount*CUP_UK_TO_QUART_US_DRY;
    }
    public static double cupUKToQuartUS(double amount){
        return amount*CUP_UK_TO_QUART_US;
    }
    public static double cupUKToTablespoonEU(double amount){
        return amount*CUP_UK_TO_TABLESPOON_EU;
    }
    public static double cupUKToTablespoonUK(double amount){
        return amount*CUP_UK_TO_TABLESPOON_UK;
    }
    public static double cupUKToTablespoonUS(double amount){
        return amount*CUP_UK_TO_TABLESPOON_US;
    }
    public static double cupUKToTeaspoonEU(double amount){
        return amount*CUP_UK_TO_TEASPOON_EU;
    }
    public static double cupUKToTeaspoonUK(double amount){
        return amount*CUP_UK_TO_TEASPOON_UK;
    }
    public static double cupUKToTeaspoonUS(double amount){
        return amount*CUP_UK_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM CUP (US) ************************************************

    public static double cupUSToCupUK(double amount){
        return amount*CUP_US_TO_CUP_UK;
    }
    public static double cupUSToDeciliter(double amount){
        return amount*CUP_US_TO_DECILITER;
    }
    public static double cupUSToDessertspoonEU(double amount){
        return amount*CUP_US_TO_DESSERTSPOON_EU;
    }
    public static double cupUSToDessertspoonUK(double amount){
        return amount*CUP_US_TO_DESSERTSPOON_UK;
    }
    public static double cupUSToDessertspoonUS(double amount){
        return amount*CUP_US_TO_DESSERTSPOON_US;
    }
    public static double cupUSToFluidOunceUK(double amount){
        return amount*CUP_US_TO_FLUID_OUNCE_UK;
    }
    public static double cupUSToFluidOunceUS(double amount){
        return amount*CUP_US_TO_FLUID_OUNCE_US;
    }
    public static double cupUSToGallonUK(double amount){
        return amount*CUP_US_TO_GALLON_UK;
    }
    public static double cupUSToGallonUSDry(double amount){
        return amount*CUP_US_TO_GALLON_US_DRY;
    }
    public static double cupUSToGallonUS(double amount){
        return amount*CUP_US_TO_GALLON_US;
    }
    public static double cupUSToLiter(double amount){
        return amount*CUP_US_TO_LITER;
    }
    public static double cupUSToMilliliter(double amount){
        return amount*CUP_US_TO_MILLILITER;
    }
    public static double cupUSToPintUK(double amount){
        return amount*CUP_US_TO_PINT_UK;
    }
    public static double cupUSToPintUSDry(double amount){
        return amount*CUP_US_TO_PINT_US_DRY;
    }
    public static double cupUSToPintUS(double amount){
        return amount*CUP_US_TO_PINT_US;
    }
    public static double cupUSToQuartUK(double amount){
        return amount*CUP_US_TO_QUART_UK;
    }
    public static double cupUSToQuartUSDry(double amount){
        return amount*CUP_US_TO_QUART_US_DRY;
    }
    public static double cupUSToQuartUS(double amount){
        return amount*CUP_US_TO_QUART_US;
    }
    public static double cupUSToTablespoonEU(double amount){
        return amount*CUP_US_TO_TABLESPOON_EU;
    }
    public static double cupUSToTablespoonUK(double amount){
        return amount*CUP_US_TO_TABLESPOON_UK;
    }
    public static double cupUSToTablespoonUS(double amount){
        return amount*CUP_US_TO_TABLESPOON_US;
    }
    public static double cupUSToTeaspoonEU(double amount){
        return amount*CUP_US_TO_TEASPOON_EU;
    }
    public static double cupUSToTeaspoonUK(double amount){
        return amount*CUP_US_TO_TEASPOON_UK;
    }
    public static double cupUSToTeaspoonUS(double amount){
        return amount*CUP_US_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM DECILITER ***********************************************

    public static double deciliterToCupUK(double amount){
        return amount*DECILITER_TO_CUP_UK;
    }
    public static double deciliterToCupUS(double amount){
        return amount*DECILITER_TO_CUP_US;
    }
    public static double deciliterToDessertspoonEU(double amount){
        return amount*DECILITER_TO_DESSERTSPOON_EU;
    }
    public static double deciliterToDessertspoonUK(double amount){
        return amount*DECILITER_TO_DESSERTSPOON_UK;
    }
    public static double deciliterToDessertspoonUS(double amount){
        return amount*DECILITER_TO_DESSERTSPOON_US;
    }
    public static double deciliterToFluidOunceUK(double amount){
        return amount*DECILITER_TO_FLUID_OUNCE_UK;
    }
    public static double deciliterToFluidOunceUS(double amount){
        return amount*DECILITER_TO_FLUID_OUNCE_US;
    }
    public static double deciliterToGallonUK(double amount){
        return amount*DECILITER_TO_GALLON_UK;
    }
    public static double deciliterToGallonUSDry(double amount){
        return amount*DECILITER_TO_GALLON_US_DRY;
    }
    public static double deciliterToGallonUS(double amount){
        return amount*DECILITER_TO_GALLON_US;
    }
    public static double deciliterToLiter(double amount){
        return amount*DECILITER_TO_LITER;
    }
    public static double deciliterToMilliliter(double amount){
        return amount*DECILITER_TO_MILLILITER;
    }
    public static double deciliterToPintUK(double amount){
        return amount*DECILITER_TO_PINT_UK;
    }
    public static double deciliterToPintUSDry(double amount){
        return amount*DECILITER_TO_PINT_US_DRY;
    }
    public static double deciliterToPintUS(double amount){
        return amount*DECILITER_TO_PINT_US;
    }
    public static double deciliterToQuartUK(double amount){
        return amount*DECILITER_TO_QUART_UK;
    }
    public static double deciliterToQuartUSDry(double amount){
        return amount*DECILITER_TO_QUART_US_DRY;
    }
    public static double deciliterToQuartUS(double amount){
        return amount*DECILITER_TO_QUART_US;
    }
    public static double deciliterToTablespoonEU(double amount){
        return amount*DECILITER_TO_TABLESPOON_EU;
    }
    public static double deciliterToTablespoonUK(double amount){
        return amount*DECILITER_TO_TABLESPOON_UK;
    }
    public static double deciliterToTablespoonUS(double amount){
        return amount*DECILITER_TO_TABLESPOON_US;
    }
    public static double deciliterToTeaspoonEU(double amount){
        return amount*DECILITER_TO_TEASPOON_EU;
    }
    public static double deciliterToTeaspoonUK(double amount){
        return amount*DECILITER_TO_TEASPOON_UK;
    }
    public static double deciliterToTeaspoonUS(double amount){
        return amount*DECILITER_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM DESSERTSPOON (EU) ***************************************

    public static double dessertspoonEUToCupUK(double amount){
        return amount*DESSERTSPOON_EU_TO_CUP_UK;
    }
    public static double dessertspoonEUToCupUS(double amount){
        return amount*DESSERTSPOON_EU_TO_CUP_US;
    }
    public static double dessertspoonEUToDeciliter(double amount){
        return amount*DESSERTSPOON_EU_TO_DECILITER;
    }
    public static double dessertspoonEUToDessertspoonUK(double amount){
        return amount*DESSERTSPOON_EU_TO_DESSERTSPOON_UK;
    }
    public static double dessertspoonEUToDessertspoonUS(double amount){
        return amount*DESSERTSPOON_EU_TO_DESSERTSPOON_US;
    }
    public static double dessertspoonEUToFluidOunceUK(double amount){
        return amount*DESSERTSPOON_EU_TO_FLUID_OUNCE_UK;
    }
    public static double dessertspoonEUToFluidOunceUS(double amount){
        return amount*DESSERTSPOON_EU_TO_FLUID_OUNCE_US;
    }
    public static double dessertspoonEUToGallonUK(double amount){
        return amount*DESSERTSPOON_EU_TO_GALLON_UK;
    }
    public static double dessertspoonEUToGallonUSDry(double amount){
        return amount*DESSERTSPOON_EU_TO_GALLON_US_DRY;
    }
    public static double dessertspoonEUToGallonUS(double amount){
        return amount*DESSERTSPOON_EU_TO_GALLON_US;
    }
    public static double dessertspoonEUToLiter(double amount){
        return amount*DESSERTSPOON_EU_TO_LITER;
    }
    public static double dessertspoonEUToMilliliter(double amount){
        return amount*DESSERTSPOON_EU_TO_MILLILITER;
    }
    public static double dessertspoonEUToPintUK(double amount){
        return amount*DESSERTSPOON_EU_TO_PINT_UK;
    }
    public static double dessertspoonEUToPintUSDry(double amount){
        return amount*DESSERTSPOON_EU_TO_PINT_US_DRY;
    }
    public static double dessertspoonEUToPintUS(double amount){
        return amount*DESSERTSPOON_EU_TO_PINT_US;
    }
    public static double dessertspoonEUToQuartUK(double amount){
        return amount*DESSERTSPOON_EU_TO_QUART_UK;
    }
    public static double dessertspoonEUToQuartUSDry(double amount){
        return amount*DESSERTSPOON_EU_TO_QUART_US_DRY;
    }
    public static double dessertspoonEUToQuartUS(double amount){
        return amount*DESSERTSPOON_EU_TO_QUART_US;
    }
    public static double dessertspoonEUToTablespoonEU(double amount){
        return amount*DESSERTSPOON_EU_TO_TABLESPOON_EU;
    }
    public static double dessertspoonEUToTablespoonUK(double amount){
        return amount*DESSERTSPOON_EU_TO_TABLESPOON_UK;
    }
    public static double dessertspoonEUToTablespoonUS(double amount){
        return amount*DESSERTSPOON_EU_TO_TABLESPOON_US;
    }
    public static double dessertspoonEUToTeaspoonEU(double amount){
        return amount*DESSERTSPOON_EU_TO_TEASPOON_EU;
    }
    public static double dessertspoonEUToTeaspoonUK(double amount){
        return amount*DESSERTSPOON_EU_TO_TEASPOON_UK;
    }
    public static double dessertspoonEUToTeaspoonUS(double amount){
        return amount*DESSERTSPOON_EU_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM DESSERTSPOON (UK) ***************************************

    public static double dessertspoonUKToCupUK(double amount){
        return amount*DESSERTSPOON_UK_TO_CUP_UK;
    }
    public static double dessertspoonUKToCupUS(double amount){
        return amount*DESSERTSPOON_UK_TO_CUP_US;
    }
    public static double dessertspoonUKToDeciliter(double amount){
        return amount*DESSERTSPOON_UK_TO_DECILITER;
    }
    public static double dessertspoonUKToDessertspoonEU(double amount){
        return amount*DESSERTSPOON_UK_TO_DESSERTSPOON_EU;
    }
    public static double dessertspoonUKToDessertspoonUS(double amount){
        return amount*DESSERTSPOON_UK_TO_DESSERTSPOON_US;
    }
    public static double dessertspoonUKToFluidOunceUK(double amount){
        return amount*DESSERTSPOON_UK_TO_FLUID_OUNCE_UK;
    }
    public static double dessertspoonUKToFluidOunceUS(double amount){
        return amount*DESSERTSPOON_UK_TO_FLUID_OUNCE_US;
    }
    public static double dessertspoonUKToGallonUK(double amount){
        return amount*DESSERTSPOON_UK_TO_GALLON_UK;
    }
    public static double dessertspoonUKToGallonUSDry(double amount){
        return amount*DESSERTSPOON_UK_TO_GALLON_US_DRY;
    }
    public static double dessertspoonUKToGallonUS(double amount){
        return amount*DESSERTSPOON_UK_TO_GALLON_US;
    }
    public static double dessertspoonUKToLiter(double amount){
        return amount*DESSERTSPOON_UK_TO_LITER;
    }
    public static double dessertspoonUKToMilliliter(double amount){
        return amount*DESSERTSPOON_UK_TO_MILLILITER;
    }
    public static double dessertspoonUKToPintUK(double amount){
        return amount*DESSERTSPOON_UK_TO_PINT_UK;
    }
    public static double dessertspoonUKToPintUSDry(double amount){
        return amount*DESSERTSPOON_UK_TO_PINT_US_DRY;
    }
    public static double dessertspoonUKToPintUS(double amount){
        return amount*DESSERTSPOON_UK_TO_PINT_US;
    }
    public static double dessertspoonUKToQuartUK(double amount){
        return amount*DESSERTSPOON_UK_TO_QUART_UK;
    }
    public static double dessertspoonUKToQuartUSDry(double amount){
        return amount*DESSERTSPOON_UK_TO_QUART_US_DRY;
    }
    public static double dessertspoonUKToQuartUS(double amount){
        return amount*DESSERTSPOON_UK_TO_QUART_US;
    }
    public static double dessertspoonUKToTablespoonEU(double amount){
        return amount*DESSERTSPOON_UK_TO_TABLESPOON_EU;
    }
    public static double dessertspoonUKToTablespoonUK(double amount){
        return amount*DESSERTSPOON_UK_TO_TABLESPOON_UK;
    }
    public static double dessertspoonUKToTablespoonUS(double amount){
        return amount*DESSERTSPOON_UK_TO_TABLESPOON_US;
    }
    public static double dessertspoonUKToTeaspoonEU(double amount){
        return amount*DESSERTSPOON_UK_TO_TEASPOON_EU;
    }
    public static double dessertspoonUKToTeaspoonUK(double amount){
        return amount*DESSERTSPOON_UK_TO_TEASPOON_UK;
    }
    public static double dessertspoonUKToTeaspoonUS(double amount){
        return amount*DESSERTSPOON_UK_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM DESSERTSPOON (US) ***************************************

    public static double dessertspoonUSToCupUK(double amount){
        return amount*DESSERTSPOON_US_TO_CUP_UK;
    }
    public static double dessertspoonUSToCupUS(double amount){
        return amount*DESSERTSPOON_US_TO_CUP_US;
    }
    public static double dessertspoonUSToDeciliter(double amount){
        return amount*DESSERTSPOON_US_TO_DECILITER;
    }
    public static double dessertspoonUSToDessertspoonEU(double amount){
        return amount*DESSERTSPOON_US_TO_DESSERTSPOON_EU;
    }
    public static double dessertspoonUSToDessertspoonUK(double amount){
        return amount*DESSERTSPOON_US_TO_DESSERTSPOON_UK;
    }
    public static double dessertspoonUSToFluidOunceUK(double amount){
        return amount*DESSERTSPOON_US_TO_FLUID_OUNCE_UK;
    }
    public static double dessertspoonUSToFluidOunceUS(double amount){
        return amount*DESSERTSPOON_US_TO_FLUID_OUNCE_US;
    }
    public static double dessertspoonUSToGallonUK(double amount){
        return amount*DESSERTSPOON_US_TO_GALLON_UK;
    }
    public static double dessertspoonUSToGallonUSDry(double amount){
        return amount*DESSERTSPOON_US_TO_GALLON_US_DRY;
    }
    public static double dessertspoonUSToGallonUS(double amount){
        return amount*DESSERTSPOON_US_TO_GALLON_US;
    }
    public static double dessertspoonUSToLiter(double amount){
        return amount*DESSERTSPOON_US_TO_LITER;
    }
    public static double dessertspoonUSToMilliliter(double amount){
        return amount*DESSERTSPOON_US_TO_MILLILITER;
    }
    public static double dessertspoonUSToPintUK(double amount){
        return amount*DESSERTSPOON_US_TO_PINT_UK;
    }
    public static double dessertspoonUSToPintUSDry(double amount){
        return amount*DESSERTSPOON_US_TO_PINT_US_DRY;
    }
    public static double dessertspoonUSToPintUS(double amount){
        return amount*DESSERTSPOON_US_TO_PINT_US;
    }
    public static double dessertspoonUSToQuartUK(double amount){
        return amount*DESSERTSPOON_US_TO_QUART_UK;
    }
    public static double dessertspoonUSToQuartUSDry(double amount){
        return amount*DESSERTSPOON_US_TO_QUART_US_DRY;
    }
    public static double dessertspoonUSToQuartUS(double amount){
        return amount*DESSERTSPOON_US_TO_QUART_US;
    }
    public static double dessertspoonUSToTablespoonEU(double amount){
        return amount*DESSERTSPOON_US_TO_TABLESPOON_EU;
    }
    public static double dessertspoonUSToTablespoonUK(double amount){
        return amount*DESSERTSPOON_US_TO_TABLESPOON_UK;
    }
    public static double dessertspoonUSToTablespoonUS(double amount){
        return amount*DESSERTSPOON_US_TO_TABLESPOON_US;
    }
    public static double dessertspoonUSToTeaspoonEU(double amount){
        return amount*DESSERTSPOON_US_TO_TEASPOON_EU;
    }
    public static double dessertspoonUSToTeaspoonUK(double amount){
        return amount*DESSERTSPOON_US_TO_TEASPOON_UK;
    }
    public static double dessertspoonUSToTeaspoonUS(double amount){
        return amount*DESSERTSPOON_US_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM FLUID OUNCE (UK) ****************************************

    public static double fluidOunceUKToCupUK(double amount){
        return amount*FLUID_OUNCE_UK_TO_CUP_UK;
    }
    public static double fluidOunceUKToCupUS(double amount){
        return amount*FLUID_OUNCE_UK_TO_CUP_US;
    }
    public static double fluidOunceUKToDeciliter(double amount){
        return amount*FLUID_OUNCE_UK_TO_DECILITER;
    }
    public static double fluidOunceUKToDessertspoonEU(double amount){
        return amount*FLUID_OUNCE_UK_TO_DESSERTSPOON_EU;
    }
    public static double fluidOunceUKToDessertspoonUK(double amount){
        return amount*FLUID_OUNCE_UK_TO_DESSERTSPOON_UK;
    }
    public static double fluidOunceUKToDessertspoonUS(double amount){
        return amount*FLUID_OUNCE_UK_TO_DESSERTSPOON_US;
    }
    public static double fluidOunceUKToFluidOunceUS(double amount){
        return amount*FLUID_OUNCE_UK_TO_FLUID_OUNCE_US;
    }
    public static double fluidOunceUKToGallonUK(double amount){
        return amount*FLUID_OUNCE_UK_TO_GALLON_UK;
    }
    public static double fluidOunceUKToGallonUSDry(double amount){
        return amount*FLUID_OUNCE_UK_TO_GALLON_US_DRY;
    }
    public static double fluidOunceUKToGallonUS(double amount){
        return amount*FLUID_OUNCE_UK_TO_GALLON_US;
    }
    public static double fluidOunceUKToLiter(double amount){
        return amount*FLUID_OUNCE_UK_TO_LITER;
    }
    public static double fluidOunceUKToMilliliter(double amount){
        return amount*FLUID_OUNCE_UK_TO_MILLILITER;
    }
    public static double fluidOunceUKToPintUK(double amount){
        return amount*FLUID_OUNCE_UK_TO_PINT_UK;
    }
    public static double fluidOunceUKToPintUSDry(double amount){
        return amount*FLUID_OUNCE_UK_TO_PINT_US_DRY;
    }
    public static double fluidOunceUKToPintUS(double amount){
        return amount*FLUID_OUNCE_UK_TO_PINT_US;
    }
    public static double fluidOunceUKToQuartUK(double amount){
        return amount*FLUID_OUNCE_UK_TO_QUART_UK;
    }
    public static double fluidOunceUKToQuartUSDry(double amount){
        return amount*FLUID_OUNCE_UK_TO_QUART_US_DRY;
    }
    public static double fluidOunceUKToQuartUS(double amount){
        return amount*FLUID_OUNCE_UK_TO_QUART_US;
    }
    public static double fluidOunceUKToTablespoonEU(double amount){
        return amount*FLUID_OUNCE_UK_TO_TABLESPOON_EU;
    }
    public static double fluidOunceUKToTablespoonUK(double amount){
        return amount*FLUID_OUNCE_UK_TO_TABLESPOON_UK;
    }
    public static double fluidOunceUKToTablespoonUS(double amount){
        return amount*FLUID_OUNCE_UK_TO_TABLESPOON_US;
    }
    public static double fluidOunceUKToTeaspoonEU(double amount){
        return amount*FLUID_OUNCE_UK_TO_TEASPOON_EU;
    }
    public static double fluidOunceUKToTeaspoonUK(double amount){
        return amount*FLUID_OUNCE_UK_TO_TEASPOON_UK;
    }
    public static double fluidOunceUKToTeaspoonUS(double amount){
        return amount*FLUID_OUNCE_UK_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM FLUID OUNCE (US) ****************************************

    public static double fluidOunceUSToCupUK(double amount){
        return amount*FLUID_OUNCE_US_TO_CUP_UK;
    }
    public static double fluidOunceUSToCupUS(double amount){
        return amount*FLUID_OUNCE_US_TO_CUP_US;
    }
    public static double fluidOunceUSToDeciliter(double amount){
        return amount*FLUID_OUNCE_US_TO_DECILITER;
    }
    public static double fluidOunceUSToDessertspoonEU(double amount){
        return amount*FLUID_OUNCE_US_TO_DESSERTSPOON_EU;
    }
    public static double fluidOunceUSToDessertspoonUK(double amount){
        return amount*FLUID_OUNCE_US_TO_DESSERTSPOON_UK;
    }
    public static double fluidOunceUSToDessertspoonUS(double amount){
        return amount*FLUID_OUNCE_US_TO_DESSERTSPOON_US;
    }
    public static double fluidOunceUSToFluidOunceUK(double amount){
        return amount*FLUID_OUNCE_US_TO_FLUID_OUNCE_UK;
    }
    public static double fluidOunceUSToGallonUK(double amount){
        return amount*FLUID_OUNCE_US_TO_GALLON_UK;
    }
    public static double fluidOunceUSToGallonUSDry(double amount){
        return amount*FLUID_OUNCE_US_TO_GALLON_US_DRY;
    }
    public static double fluidOunceUSToGallonUS(double amount){
        return amount*FLUID_OUNCE_US_TO_GALLON_US;
    }
    public static double fluidOunceUSToLiter(double amount){
        return amount*FLUID_OUNCE_US_TO_LITER;
    }
    public static double fluidOunceUSToMilliliter(double amount){
        return amount*FLUID_OUNCE_US_TO_MILLILITER;
    }
    public static double fluidOunceUSToPintUK(double amount){
        return amount*FLUID_OUNCE_US_TO_PINT_UK;
    }
    public static double fluidOunceUSToPintUSDry(double amount){
        return amount*FLUID_OUNCE_US_TO_PINT_US_DRY;
    }
    public static double fluidOunceUSToPintUS(double amount){
        return amount*FLUID_OUNCE_US_TO_PINT_US;
    }
    public static double fluidOunceUSToQuartUK(double amount){
        return amount*FLUID_OUNCE_US_TO_QUART_UK;
    }
    public static double fluidOunceUSToQuartUSDry(double amount){
        return amount*FLUID_OUNCE_US_TO_QUART_US_DRY;
    }
    public static double fluidOunceUSToQuartUS(double amount){
        return amount*FLUID_OUNCE_US_TO_QUART_US;
    }
    public static double fluidOunceUSToTablespoonEU(double amount){
        return amount*FLUID_OUNCE_US_TO_TABLESPOON_EU;
    }
    public static double fluidOunceUSToTablespoonUK(double amount){
        return amount*FLUID_OUNCE_US_TO_TABLESPOON_UK;
    }
    public static double fluidOunceUSToTablespoonUS(double amount){
        return amount*FLUID_OUNCE_US_TO_TABLESPOON_US;
    }
    public static double fluidOunceUSToTeaspoonEU(double amount){
        return amount*FLUID_OUNCE_US_TO_TEASPOON_EU;
    }
    public static double fluidOunceUSToTeaspoonUK(double amount){
        return amount*FLUID_OUNCE_US_TO_TEASPOON_UK;
    }
    public static double fluidOunceUSToTeaspoonUS(double amount){
        return amount*FLUID_OUNCE_US_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM GALLON (UK) *********************************************

    public static double gallonUKToCupUK(double amount){
        return amount*GALLON_UK_TO_CUP_UK;
    }
    public static double gallonUKToCupUS(double amount){
        return amount*GALLON_UK_TO_CUP_US;
    }
    public static double gallonUKToDeciliter(double amount){
        return amount*GALLON_UK_TO_DECILITER;
    }
    public static double gallonUKToDessertspoonEU(double amount){
        return amount*GALLON_UK_TO_DESSERTSPOON_EU;
    }
    public static double gallonUKToDessertspoonUK(double amount){
        return amount*GALLON_UK_TO_DESSERTSPOON_UK;
    }
    public static double gallonUKToDessertspoonUS(double amount){
        return amount*GALLON_UK_TO_DESSERTSPOON_US;
    }
    public static double gallonUKToFluidOunceUK(double amount){
        return amount*GALLON_UK_TO_FLUID_OUNCE_UK;
    }
    public static double gallonUKToFluidOunceUS(double amount){
        return amount*GALLON_UK_TO_FLUID_OUNCE_US;
    }
    public static double gallonUKToGallonUSDry(double amount){
        return amount*GALLON_UK_TO_GALLON_US_DRY;
    }
    public static double gallonUKToGallonUS(double amount){
        return amount*GALLON_UK_TO_GALLON_US;
    }
    public static double gallonUKToLiter(double amount){
        return amount*GALLON_UK_TO_LITER;
    }
    public static double gallonUKToMilliliter(double amount){
        return amount*GALLON_UK_TO_MILLILITER;
    }
    public static double gallonUKToPintUK(double amount){
        return amount*GALLON_UK_TO_PINT_UK;
    }
    public static double gallonUKToPintUSDry(double amount){
        return amount*GALLON_UK_TO_PINT_US_DRY;
    }
    public static double gallonUKToPintUS(double amount){
        return amount*GALLON_UK_TO_PINT_US;
    }
    public static double gallonUKToQuartUK(double amount){
        return amount*GALLON_UK_TO_QUART_UK;
    }
    public static double gallonUKToQuartUSDry(double amount){
        return amount*GALLON_UK_TO_QUART_US_DRY;
    }
    public static double gallonUKToQuartUS(double amount){
        return amount*GALLON_UK_TO_QUART_US;
    }
    public static double gallonUKToTablespoonEU(double amount){
        return amount*GALLON_UK_TO_TABLESPOON_EU;
    }
    public static double gallonUKToTablespoonUK(double amount){
        return amount*GALLON_UK_TO_TABLESPOON_UK;
    }
    public static double gallonUKToTablespoonUS(double amount){
        return amount*GALLON_UK_TO_TABLESPOON_US;
    }
    public static double gallonUKToTeaspoonEU(double amount){
        return amount*GALLON_UK_TO_TEASPOON_EU;
    }
    public static double gallonUKToTeaspoonUK(double amount){
        return amount*GALLON_UK_TO_TEASPOON_UK;
    }
    public static double gallonUKToTeaspoonUS(double amount){
        return amount*GALLON_UK_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM GALLON (US, DRY) *********************************************

    public static double gallonUSDryToCupUK(double amount){
        return amount*GALLON_US_DRY_TO_CUP_UK;
    }
    public static double gallonUSDryToCupUS(double amount){
        return amount*GALLON_US_DRY_TO_CUP_US;
    }
    public static double gallonUSDryToDeciliter(double amount){
        return amount*GALLON_US_DRY_TO_DECILITER;
    }
    public static double gallonUSDryToDessertspoonEU(double amount){
        return amount*GALLON_US_DRY_TO_DESSERTSPOON_EU;
    }
    public static double gallonUSDryToDessertspoonUK(double amount){
        return amount*GALLON_US_DRY_TO_DESSERTSPOON_UK;
    }
    public static double gallonUSDryToDessertspoonUS(double amount){
        return amount*GALLON_US_DRY_TO_DESSERTSPOON_US;
    }
    public static double gallonUSDryToFluidOunceUK(double amount){
        return amount*GALLON_US_DRY_TO_FLUID_OUNCE_UK;
    }
    public static double gallonUSDryToFluidOunceUS(double amount){
        return amount*GALLON_US_DRY_TO_FLUID_OUNCE_US;
    }
    public static double gallonUSDryToGallonUK(double amount){
        return amount*GALLON_US_DRY_TO_GALLON_UK;
    }
    public static double gallonUSDryToGallonUS(double amount){
        return amount*GALLON_US_DRY_TO_GALLON_US;
    }
    public static double gallonUSDryToLiter(double amount){
        return amount*GALLON_US_DRY_TO_LITER;
    }
    public static double gallonUSDryToMilliliter(double amount){
        return amount*GALLON_US_DRY_TO_MILLILITER;
    }
    public static double gallonUSDryToPintUK(double amount){
        return amount*GALLON_US_DRY_TO_PINT_UK;
    }
    public static double gallonUSDryToPintUSDry(double amount){
        return amount*GALLON_US_DRY_TO_PINT_US_DRY;
    }
    public static double gallonUSDryToPintUS(double amount){
        return amount*GALLON_US_DRY_TO_PINT_US;
    }
    public static double gallonUSDryToQuartUK(double amount){
        return amount*GALLON_US_DRY_TO_QUART_UK;
    }
    public static double gallonUSDryToQuartUSDry(double amount){
        return amount*GALLON_US_DRY_TO_QUART_US_DRY;
    }
    public static double gallonUSDryToQuartUS(double amount){
        return amount*GALLON_US_DRY_TO_QUART_US;
    }
    public static double gallonUSDryToTablespoonEU(double amount){
        return amount*GALLON_US_DRY_TO_TABLESPOON_EU;
    }
    public static double gallonUSDryToTablespoonUK(double amount){
        return amount*GALLON_US_DRY_TO_TABLESPOON_UK;
    }
    public static double gallonUSDryToTablespoonUS(double amount){
        return amount*GALLON_US_DRY_TO_TABLESPOON_US;
    }
    public static double gallonUSDryToTeaspoonEU(double amount){
        return amount*GALLON_US_DRY_TO_TEASPOON_EU;
    }
    public static double gallonUSDryToTeaspoonUK(double amount){
        return amount*GALLON_US_DRY_TO_TEASPOON_UK;
    }
    public static double gallonUSDryToTeaspoonUS(double amount){
        return amount*GALLON_US_DRY_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM GALLON (US, LIQUID) *********************************************

    public static double gallonUSToCupUK(double amount){
        return amount*GALLON_US_TO_CUP_UK;
    }
    public static double gallonUSToCupUS(double amount){
        return amount*GALLON_US_TO_CUP_US;
    }
    public static double gallonUSToDeciliter(double amount){
        return amount*GALLON_US_TO_DECILITER;
    }
    public static double gallonUSToDessertspoonEU(double amount){
        return amount*GALLON_US_TO_DESSERTSPOON_EU;
    }
    public static double gallonUSToDessertspoonUK(double amount){
        return amount*GALLON_US_TO_DESSERTSPOON_UK;
    }
    public static double gallonUSToDessertspoonUS(double amount){
        return amount*GALLON_US_TO_DESSERTSPOON_US;
    }
    public static double gallonUSToFluidOunceUK(double amount){
        return amount*GALLON_US_TO_FLUID_OUNCE_UK;
    }
    public static double gallonUSToFluidOunceUS(double amount){
        return amount*GALLON_US_TO_FLUID_OUNCE_US;
    }
    public static double gallonUSToGallonUK(double amount){
        return amount*GALLON_US_TO_GALLON_UK;
    }
    public static double gallonUSToGallonUSDry(double amount){
        return amount*GALLON_US_TO_GALLON_US_DRY;
    }
    public static double gallonUSToLiter(double amount){
        return amount*GALLON_US_TO_LITER;
    }
    public static double gallonUSToMilliliter(double amount){
        return amount*GALLON_US_TO_MILLILITER;
    }
    public static double gallonUSToPintUK(double amount){
        return amount*GALLON_US_TO_PINT_UK;
    }
    public static double gallonUSToPintUSDry(double amount){
        return amount*GALLON_US_TO_PINT_US_DRY;
    }
    public static double gallonUSToPintUS(double amount){
        return amount*GALLON_US_TO_PINT_US;
    }
    public static double gallonUSToQuartUK(double amount){
        return amount*GALLON_US_TO_QUART_UK;
    }
    public static double gallonUSToQuartUSDry(double amount){
        return amount*GALLON_US_TO_QUART_US_DRY;
    }
    public static double gallonUSToQuartUS(double amount){
        return amount*GALLON_US_TO_QUART_US;
    }
    public static double gallonUSToTablespoonEU(double amount){
        return amount*GALLON_US_TO_TABLESPOON_EU;
    }
    public static double gallonUSToTablespoonUK(double amount){
        return amount*GALLON_US_TO_TABLESPOON_UK;
    }
    public static double gallonUSToTablespoonUS(double amount){
        return amount*GALLON_US_TO_TABLESPOON_US;
    }
    public static double gallonUSToTeaspoonEU(double amount){
        return amount*GALLON_US_TO_TEASPOON_EU;
    }
    public static double gallonUSToTeaspoonUK(double amount){
        return amount*GALLON_US_TO_TEASPOON_UK;
    }
    public static double gallonUSToTeaspoonUS(double amount){
        return amount*GALLON_US_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM LITER ***************************************************

    public static double literToCupUK(double amount){
        return amount*LITER_TO_CUP_UK;
    }
    public static double literToCupUS(double amount){
        return amount*LITER_TO_CUP_US;
    }
    public static double literToDeciliter(double amount){
        return amount*LITER_TO_DECILITER;
    }
    public static double literToDessertspoonEU(double amount){
        return amount*LITER_TO_DESSERTSPOON_EU;
    }
    public static double literToDessertspoonUK(double amount){
        return amount*LITER_TO_DESSERTSPOON_UK;
    }
    public static double literToDessertspoonUS(double amount){
        return amount*LITER_TO_DESSERTSPOON_US;
    }
    public static double literToFluidOunceUK(double amount){
        return amount*LITER_TO_FLUID_OUNCE_UK;
    }
    public static double literToFluidOunceUS(double amount){
        return amount*LITER_TO_FLUID_OUNCE_US;
    }
    public static double literToGallonUK(double amount){
        return amount*LITER_TO_GALLON_UK;
    }
    public static double literToGallonUSDry(double amount){
        return amount*LITER_TO_GALLON_US_DRY;
    }
    public static double literToGallonUS(double amount){
        return amount*LITER_TO_GALLON_US;
    }
    public static double literToMilliliter(double amount){
        return amount*LITER_TO_MILLILITER;
    }
    public static double literToPintUK(double amount){
        return amount*LITER_TO_PINT_UK;
    }
    public static double literToPintUSDry(double amount){
        return amount*LITER_TO_PINT_US_DRY;
    }
    public static double literToPintUS(double amount){
        return amount*LITER_TO_PINT_US;
    }
    public static double literToQuartUK(double amount){
        return amount*LITER_TO_QUART_UK;
    }
    public static double literToQuartUSDry(double amount){
        return amount*LITER_TO_QUART_US_DRY;
    }
    public static double literToQuartUS(double amount){
        return amount*LITER_TO_QUART_US;
    }
    public static double literToTablespoonEU(double amount){
        return amount*LITER_TO_TABLESPOON_EU;
    }
    public static double literToTablespoonUK(double amount){
        return amount*LITER_TO_TABLESPOON_UK;
    }
    public static double literToTablespoonUS(double amount){
        return amount*LITER_TO_TABLESPOON_US;
    }
    public static double literToTeaspoonEU(double amount){
        return amount*LITER_TO_TEASPOON_EU;
    }
    public static double literToTeaspoonUK(double amount){
        return amount*LITER_TO_TEASPOON_UK;
    }
    public static double literToTeaspoonUS(double amount){
        return amount*LITER_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM MILLILITER **********************************************

    public static double milliliterToCupUK(double amount){
        return amount*MILLILITER_TO_CUP_UK;
    }
    public static double milliliterToCupUS(double amount){
        return amount*MILLILITER_TO_CUP_US;
    }
    public static double milliliterToDeciliter(double amount){
        return amount*MILLILITER_TO_DECILITER;
    }
    public static double milliliterToDessertspoonEU(double amount){
        return amount*MILLILITER_TO_DESSERTSPOON_EU;
    }
    public static double milliliterToDessertspoonUK(double amount){
        return amount*MILLILITER_TO_DESSERTSPOON_UK;
    }
    public static double milliliterToDessertspoonUS(double amount){
        return amount*MILLILITER_TO_DESSERTSPOON_US;
    }
    public static double milliliterToFluidOunceUK(double amount){
        return amount*MILLILITER_TO_FLUID_OUNCE_UK;
    }
    public static double milliliterToFluidOunceUS(double amount){
        return amount*MILLILITER_TO_FLUID_OUNCE_US;
    }
    public static double milliliterToGallonUK(double amount){
        return amount*MILLILITER_TO_GALLON_UK;
    }
    public static double milliliterToGallonUSDry(double amount){
        return amount*MILLILITER_TO_GALLON_US_DRY;
    }
    public static double milliliterToGallonUS(double amount){
        return amount*MILLILITER_TO_GALLON_US;
    }
    public static double milliliterToLiter(double amount){
        return amount*MILLILITER_TO_LITER;
    }
    public static double milliliterToPintUK(double amount){
        return amount*MILLILITER_TO_PINT_UK;
    }
    public static double milliliterToPintUSDry(double amount){
        return amount*MILLILITER_TO_PINT_US_DRY;
    }
    public static double milliliterToPintUS(double amount){
        return amount*MILLILITER_TO_PINT_US;
    }
    public static double milliliterToQuartUK(double amount){
        return amount*MILLILITER_TO_QUART_UK;
    }
    public static double milliliterToQuartUSDry(double amount){
        return amount*MILLILITER_TO_QUART_US_DRY;
    }
    public static double milliliterToQuartUS(double amount){
        return amount*MILLILITER_TO_QUART_US;
    }
    public static double milliliterToTablespoonEU(double amount){
        return amount*MILLILITER_TO_TABLESPOON_EU;
    }
    public static double milliliterToTablespoonUK(double amount){
        return amount*MILLILITER_TO_TABLESPOON_UK;
    }
    public static double milliliterToTablespoonUS(double amount){
        return amount*MILLILITER_TO_TABLESPOON_US;
    }
    public static double milliliterToTeaspoonEU(double amount){
        return amount*MILLILITER_TO_TEASPOON_EU;
    }
    public static double milliliterToTeaspoonUK(double amount){
        return amount*MILLILITER_TO_TEASPOON_UK;
    }
    public static double milliliterToTeaspoonUS(double amount){
        return amount*MILLILITER_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM PINT (UK) ***********************************************

    public static double pintUKToCupUK(double amount){
        return amount*PINT_UK_TO_CUP_UK;
    }
    public static double pintUKToCupUS(double amount){
        return amount*PINT_UK_TO_CUP_US;
    }
    public static double pintUKToDeciliter(double amount){
        return amount*PINT_UK_TO_DECILITER;
    }
    public static double pintUKToDessertspoonEU(double amount){
        return amount*PINT_UK_TO_DESSERTSPOON_EU;
    }
    public static double pintUKToDessertspoonUK(double amount){
        return amount*PINT_UK_TO_DESSERTSPOON_UK;
    }
    public static double pintUKToDessertspoonUS(double amount){
        return amount*PINT_UK_TO_DESSERTSPOON_US;
    }
    public static double pintUKToFluidOunceUK(double amount){
        return amount*PINT_UK_TO_FLUID_OUNCE_UK;
    }
    public static double pintUKToFluidOunceUS(double amount){
        return amount*PINT_UK_TO_FLUID_OUNCE_US;
    }
    public static double pintUKToGallonUK(double amount){
        return amount*PINT_UK_TO_GALLON_UK;
    }
    public static double pintUKToGallonUSDry(double amount){
        return amount*PINT_UK_TO_GALLON_US_DRY;
    }
    public static double pintUKToGallonUS(double amount){
        return amount*PINT_UK_TO_GALLON_US;
    }
    public static double pintUKToLiter(double amount){
        return amount*PINT_UK_TO_LITER;
    }
    public static double pintUKToMilliliter(double amount){
        return amount*PINT_UK_TO_MILLILITER;
    }
    public static double pintUKToPintUSDry(double amount){
        return amount*PINT_UK_TO_PINT_US_DRY;
    }
    public static double pintUKToPintUS(double amount){
        return amount*PINT_UK_TO_PINT_US;
    }
    public static double pintUKToQuartUK(double amount){
        return amount*PINT_UK_TO_QUART_UK;
    }
    public static double pintUKToQuartUSDry(double amount){
        return amount*PINT_UK_TO_QUART_US_DRY;
    }
    public static double pintUKToQuartUS(double amount){
        return amount*PINT_UK_TO_QUART_US;
    }
    public static double pintUKToTablespoonEU(double amount){
        return amount*PINT_UK_TO_TABLESPOON_EU;
    }
    public static double pintUKToTablespoonUK(double amount){
        return amount*PINT_UK_TO_TABLESPOON_UK;
    }
    public static double pintUKToTablespoonUS(double amount){
        return amount*PINT_UK_TO_TABLESPOON_US;
    }
    public static double pintUKToTeaspoonEU(double amount){
        return amount*PINT_UK_TO_TEASPOON_EU;
    }
    public static double pintUKToTeaspoonUK(double amount){
        return amount*PINT_UK_TO_TEASPOON_UK;
    }
    public static double pintUKToTeaspoonUS(double amount){
        return amount*PINT_UK_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM PINT (US, DRY) ***********************************************

    public static double pintUSDryToCupUK(double amount){
        return amount*PINT_US_DRY_TO_CUP_UK;
    }
    public static double pintUSDryToCupUS(double amount){
        return amount*PINT_US_DRY_TO_CUP_US;
    }
    public static double pintUSDryToDeciliter(double amount){
        return amount*PINT_US_DRY_TO_DECILITER;
    }
    public static double pintUSDryToDessertspoonEU(double amount){
        return amount*PINT_US_DRY_TO_DESSERTSPOON_EU;
    }
    public static double pintUSDryToDessertspoonUK(double amount){
        return amount*PINT_US_DRY_TO_DESSERTSPOON_UK;
    }
    public static double pintUSDryToDessertspoonUS(double amount){
        return amount*PINT_US_DRY_TO_DESSERTSPOON_US;
    }
    public static double pintUSDryToFluidOunceUK(double amount){
        return amount*PINT_US_DRY_TO_FLUID_OUNCE_UK;
    }
    public static double pintUSDryToFluidOunceUS(double amount){
        return amount*PINT_US_DRY_TO_FLUID_OUNCE_US;
    }
    public static double pintUSDryToGallonUK(double amount){
        return amount*PINT_US_DRY_TO_GALLON_UK;
    }
    public static double pintUSDryToGallonUSDry(double amount){
        return amount*PINT_US_DRY_TO_GALLON_US_DRY;
    }
    public static double pintUSDryToGallonUS(double amount){
        return amount*PINT_US_DRY_TO_GALLON_US;
    }
    public static double pintUSDryToLiter(double amount){
        return amount*PINT_US_DRY_TO_LITER;
    }
    public static double pintUSDryToMilliliter(double amount){
        return amount*PINT_US_DRY_TO_MILLILITER;
    }
    public static double pintUSDryToPintUK(double amount){
        return amount*PINT_US_DRY_TO_PINT_UK;
    }
    public static double pintUSDryToPintUS(double amount){
        return amount*PINT_US_DRY_TO_PINT_US;
    }
    public static double pintUSDryToQuartUK(double amount){
        return amount*PINT_US_DRY_TO_QUART_UK;
    }
    public static double pintUSDryToQuartUSDry(double amount){
        return amount*PINT_US_DRY_TO_QUART_US_DRY;
    }
    public static double pintUSDryToQuartUS(double amount){
        return amount*PINT_US_DRY_TO_QUART_US;
    }
    public static double pintUSDryToTablespoonEU(double amount){
        return amount*PINT_US_DRY_TO_TABLESPOON_EU;
    }
    public static double pintUSDryToTablespoonUK(double amount){
        return amount*PINT_US_DRY_TO_TABLESPOON_UK;
    }
    public static double pintUSDryToTablespoonUS(double amount){
        return amount*PINT_US_DRY_TO_TABLESPOON_US;
    }
    public static double pintUSDryToTeaspoonEU(double amount){
        return amount*PINT_US_DRY_TO_TEASPOON_EU;
    }
    public static double pintUSDryToTeaspoonUK(double amount){
        return amount*PINT_US_DRY_TO_TEASPOON_UK;
    }
    public static double pintUSDryToTeaspoonUS(double amount){
        return amount*PINT_US_DRY_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM PINT (US, LIQUID) ***********************************************

    public static double pintUSToCupUK(double amount){
        return amount*PINT_US_TO_CUP_UK;
    }
    public static double pintUSToCupUS(double amount){
        return amount*PINT_US_TO_CUP_US;
    }
    public static double pintUSToDeciliter(double amount){
        return amount*PINT_US_TO_DECILITER;
    }
    public static double pintUSToDessertspoonEU(double amount){
        return amount*PINT_US_TO_DESSERTSPOON_EU;
    }
    public static double pintUSToDessertspoonUK(double amount){
        return amount*PINT_US_TO_DESSERTSPOON_UK;
    }
    public static double pintUSToDessertspoonUS(double amount){
        return amount*PINT_US_TO_DESSERTSPOON_US;
    }
    public static double pintUSToFluidOunceUK(double amount){
        return amount*PINT_US_TO_FLUID_OUNCE_UK;
    }
    public static double pintUSToFluidOunceUS(double amount){
        return amount*PINT_US_TO_FLUID_OUNCE_US;
    }
    public static double pintUSToGallonUK(double amount){
        return amount*PINT_US_TO_GALLON_UK;
    }
    public static double pintUSToGallonUSDry(double amount){
        return amount*PINT_US_TO_GALLON_US_DRY;
    }
    public static double pintUSToGallonUS(double amount){
        return amount*PINT_US_TO_GALLON_US;
    }
    public static double pintUSToLiter(double amount){
        return amount*PINT_US_TO_LITER;
    }
    public static double pintUSToMilliliter(double amount){
        return amount*PINT_US_TO_MILLILITER;
    }
    public static double pintUSToPintUK(double amount){
        return amount*PINT_US_TO_PINT_UK;
    }
    public static double pintUSToPintUSDry(double amount){
        return amount*PINT_US_TO_PINT_US_DRY;
    }
    public static double pintUSToQuartUK(double amount){
        return amount*PINT_US_TO_QUART_UK;
    }
    public static double pintUSToQuartUSDry(double amount){
        return amount*PINT_US_TO_QUART_US_DRY;
    }
    public static double pintUSToQuartUS(double amount){
        return amount*PINT_US_TO_QUART_US;
    }
    public static double pintUSToTablespoonEU(double amount){
        return amount*PINT_US_TO_TABLESPOON_EU;
    }
    public static double pintUSToTablespoonUK(double amount){
        return amount*PINT_US_TO_TABLESPOON_UK;
    }
    public static double pintUSToTablespoonUS(double amount){
        return amount*PINT_US_TO_TABLESPOON_US;
    }
    public static double pintUSToTeaspoonEU(double amount){
        return amount*PINT_US_TO_TEASPOON_EU;
    }
    public static double pintUSToTeaspoonUK(double amount){
        return amount*PINT_US_TO_TEASPOON_UK;
    }
    public static double pintUSToTeaspoonUS(double amount){
        return amount*PINT_US_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM QUART (UK) **********************************************

    public static double quartUKToCupUK(double amount){
        return amount*QUART_UK_TO_CUP_UK;
    }
    public static double quartUKToCupUS(double amount){
        return amount*QUART_UK_TO_CUP_US;
    }
    public static double quartUKToDeciliter(double amount){
        return amount*QUART_UK_TO_DECILITER;
    }
    public static double quartUKToDessertspoonEU(double amount){
        return amount*QUART_UK_TO_DESSERTSPOON_EU;
    }
    public static double quartUKToDessertspoonUK(double amount){
        return amount*QUART_UK_TO_DESSERTSPOON_UK;
    }
    public static double quartUKToDessertspoonUS(double amount){
        return amount*QUART_UK_TO_DESSERTSPOON_US;
    }
    public static double quartUKToFluidOunceUK(double amount){
        return amount*QUART_UK_TO_FLUID_OUNCE_UK;
    }
    public static double quartUKToFluidOunceUS(double amount){
        return amount*QUART_UK_TO_FLUID_OUNCE_US;
    }
    public static double quartUKToGallonUK(double amount){
        return amount*QUART_UK_TO_GALLON_UK;
    }
    public static double quartUKToGallonUSDry(double amount){
        return amount*QUART_UK_TO_GALLON_US_DRY;
    }
    public static double quartUKToGallonUS(double amount){
        return amount*QUART_UK_TO_GALLON_US;
    }
    public static double quartUKToLiter(double amount){
        return amount*QUART_UK_TO_LITER;
    }
    public static double quartUKToMilliliter(double amount){
        return amount*QUART_UK_TO_MILLILITER;
    }
    public static double quartUKToPintUK(double amount){
        return amount*QUART_UK_TO_PINT_UK;
    }
    public static double quartUKToPintUSDry(double amount){
        return amount*QUART_UK_TO_PINT_US_DRY;
    }
    public static double quartUKToPintUS(double amount){
        return amount*QUART_UK_TO_PINT_US;
    }
    public static double quartUKToQuartUSDry(double amount){
        return amount*QUART_UK_TO_QUART_US_DRY;
    }
    public static double quartUKToQuartUS(double amount){
        return amount*QUART_UK_TO_QUART_US;
    }
    public static double quartUKToTablespoonEU(double amount){
        return amount*QUART_UK_TO_TABLESPOON_EU;
    }
    public static double quartUKToTablespoonUK(double amount){
        return amount*QUART_UK_TO_TABLESPOON_UK;
    }
    public static double quartUKToTablespoonUS(double amount){
        return amount*QUART_UK_TO_TABLESPOON_US;
    }
    public static double quartUKToTeaspoonEU(double amount){
        return amount*QUART_UK_TO_TEASPOON_EU;
    }
    public static double quartUKToTeaspoonUK(double amount){
        return amount*QUART_UK_TO_TEASPOON_UK;
    }
    public static double quartUKToTeaspoonUS(double amount){
        return amount*QUART_UK_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM QUART (US, DRY) **********************************************

    public static double quartUSDryToCupUK(double amount){
        return amount*QUART_US_DRY_TO_CUP_UK;
    }
    public static double quartUSDryToCupUS(double amount){
        return amount*QUART_US_DRY_TO_CUP_US;
    }
    public static double quartUSDryToDeciliter(double amount){
        return amount*QUART_US_DRY_TO_DECILITER;
    }
    public static double quartUSDryToDessertspoonEU(double amount){
        return amount*QUART_US_DRY_TO_DESSERTSPOON_EU;
    }
    public static double quartUSDryToDessertspoonUK(double amount){
        return amount*QUART_US_DRY_TO_DESSERTSPOON_UK;
    }
    public static double quartUSDryToDessertspoonUS(double amount){
        return amount*QUART_US_DRY_TO_DESSERTSPOON_US;
    }
    public static double quartUSDryToFluidOunceUK(double amount){
        return amount*QUART_US_DRY_TO_FLUID_OUNCE_UK;
    }
    public static double quartUSDryToFluidOunceUS(double amount){
        return amount*QUART_US_DRY_TO_FLUID_OUNCE_US;
    }
    public static double quartUSDryToGallonUK(double amount){
        return amount*QUART_US_DRY_TO_GALLON_UK;
    }
    public static double quartUSDryToGallonUSDry(double amount){
        return amount*QUART_US_DRY_TO_GALLON_US_DRY;
    }
    public static double quartUSDryToGallonUS(double amount){
        return amount*QUART_US_DRY_TO_GALLON_US;
    }
    public static double quartUSDryToLiter(double amount){
        return amount*QUART_US_DRY_TO_LITER;
    }
    public static double quartUSDryToMilliliter(double amount){
        return amount*QUART_US_DRY_TO_MILLILITER;
    }
    public static double quartUSDryToPintUK(double amount){
        return amount*QUART_US_DRY_TO_PINT_UK;
    }
    public static double quartUSDryToPintUSDry(double amount){
        return amount*QUART_US_DRY_TO_PINT_US_DRY;
    }
    public static double quartUSDryToPintUS(double amount){
        return amount*QUART_US_DRY_TO_PINT_US;
    }
    public static double quartUSDryToQuartUK(double amount){
        return amount*QUART_US_DRY_TO_QUART_UK;
    }
    public static double quartUSDryToQuartUS(double amount){
        return amount*QUART_US_DRY_TO_QUART_US;
    }
    public static double quartUSDryToTablespoonEU(double amount){
        return amount*QUART_US_DRY_TO_TABLESPOON_EU;
    }
    public static double quartUSDryToTablespoonUK(double amount){
        return amount*QUART_US_DRY_TO_TABLESPOON_UK;
    }
    public static double quartUSDryToTablespoonUS(double amount){
        return amount*QUART_US_DRY_TO_TABLESPOON_US;
    }
    public static double quartUSDryToTeaspoonEU(double amount){
        return amount*QUART_US_DRY_TO_TEASPOON_EU;
    }
    public static double quartUSDryToTeaspoonUK(double amount){
        return amount*QUART_US_DRY_TO_TEASPOON_UK;
    }
    public static double quartUSDryToTeaspoonUS(double amount){
        return amount*QUART_US_DRY_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM QUART (US, LIQUID) **********************************************

    public static double quartUSToCupUK(double amount){
        return amount*QUART_US_TO_CUP_UK;
    }
    public static double quartUSToCupUS(double amount){
        return amount*QUART_US_TO_CUP_US;
    }
    public static double quartUSToDeciliter(double amount){
        return amount*QUART_US_TO_DECILITER;
    }
    public static double quartUSToDessertspoonEU(double amount){
        return amount*QUART_US_TO_DESSERTSPOON_EU;
    }
    public static double quartUSToDessertspoonUK(double amount){
        return amount*QUART_US_TO_DESSERTSPOON_UK;
    }
    public static double quartUSToDessertspoonUS(double amount){
        return amount*QUART_US_TO_DESSERTSPOON_US;
    }
    public static double quartUSToFluidOunceUK(double amount){
        return amount*QUART_US_TO_FLUID_OUNCE_UK;
    }
    public static double quartUSToFluidOunceUS(double amount){
        return amount*QUART_US_TO_FLUID_OUNCE_US;
    }
    public static double quartUSToGallonUK(double amount){
        return amount*QUART_US_TO_GALLON_UK;
    }
    public static double quartUSToGallonUSDry(double amount){
        return amount*QUART_US_TO_GALLON_US_DRY;
    }
    public static double quartUSToGallonUS(double amount){
        return amount*QUART_US_TO_GALLON_US;
    }
    public static double quartUSToLiter(double amount){
        return amount*QUART_US_TO_LITER;
    }
    public static double quartUSToMilliliter(double amount){
        return amount*QUART_US_TO_MILLILITER;
    }
    public static double quartUSToPintUK(double amount){
        return amount*QUART_US_TO_PINT_UK;
    }
    public static double quartUSToPintUSDry(double amount){
        return amount*QUART_US_TO_PINT_US_DRY;
    }
    public static double quartUSToPintUS(double amount){
        return amount*QUART_US_TO_PINT_US;
    }
    public static double quartUSToQuartUK(double amount){
        return amount*QUART_US_TO_QUART_UK;
    }
    public static double quartUSToQuartUSDry(double amount){
        return amount*QUART_US_TO_QUART_US_DRY;
    }
    public static double quartUSToTablespoonEU(double amount){
        return amount*QUART_US_TO_TABLESPOON_EU;
    }
    public static double quartUSToTablespoonUK(double amount){
        return amount*QUART_US_TO_TABLESPOON_UK;
    }
    public static double quartUSToTablespoonUS(double amount){
        return amount*QUART_US_TO_TABLESPOON_US;
    }
    public static double quartUSToTeaspoonEU(double amount){
        return amount*QUART_US_TO_TEASPOON_EU;
    }
    public static double quartUSToTeaspoonUK(double amount){
        return amount*QUART_US_TO_TEASPOON_UK;
    }
    public static double quartUSToTeaspoonUS(double amount){
        return amount*QUART_US_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM TABLESPOON (EU) ****************************************

    public static double tablespoonEUToCupUK(double amount){
        return amount*TABLESPOON_EU_TO_CUP_UK;
    }
    public static double tablespoonEUToCupUS(double amount){
        return amount*TABLESPOON_EU_TO_CUP_US;
    }
    public static double tablespoonEUToDeciliter(double amount){
        return amount*TABLESPOON_EU_TO_DECILITER;
    }
    public static double tablespoonEUToDessertspoonEU(double amount){
        return amount*TABLESPOON_EU_TO_DESSERTSPOON_EU;
    }
    public static double tablespoonEUToDessertspoonUK(double amount){
        return amount*TABLESPOON_EU_TO_DESSERTSPOON_UK;
    }
    public static double tablespoonEUToDessertspoonUS(double amount){
        return amount*TABLESPOON_EU_TO_DESSERTSPOON_US;
    }
    public static double tablespoonEUToFluidOunceUK(double amount){
        return amount*TABLESPOON_EU_TO_FLUID_OUNCE_UK;
    }
    public static double tablespoonEUToFluidOunceUS(double amount){
        return amount*TABLESPOON_EU_TO_FLUID_OUNCE_US;
    }
    public static double tablespoonEUToGallonUK(double amount){
        return amount*TABLESPOON_EU_TO_GALLON_UK;
    }
    public static double tablespoonEUToGallonUSDry(double amount){
        return amount*TABLESPOON_EU_TO_GALLON_US_DRY;
    }
    public static double tablespoonEUToGallonUS(double amount){
        return amount*TABLESPOON_EU_TO_GALLON_US;
    }
    public static double tablespoonEUToLiter(double amount){
        return amount*TABLESPOON_EU_TO_LITER;
    }
    public static double tablespoonEUToMilliliter(double amount){
        return amount*TABLESPOON_EU_TO_MILLILITER;
    }
    public static double tablespoonEUToPintUK(double amount){
        return amount*TABLESPOON_EU_TO_PINT_UK;
    }
    public static double tablespoonEUToPintUSDry(double amount){
        return amount*TABLESPOON_EU_TO_PINT_US_DRY;
    }
    public static double tablespoonEUToPintUS(double amount){
        return amount*TABLESPOON_EU_TO_PINT_US;
    }
    public static double tablespoonEUToQuartUK(double amount){
        return amount*TABLESPOON_EU_TO_QUART_UK;
    }
    public static double tablespoonEUToQuartUSDry(double amount){
        return amount*TABLESPOON_EU_TO_QUART_US_DRY;
    }
    public static double tablespoonEUToQuartUS(double amount){
        return amount*TABLESPOON_EU_TO_QUART_US;
    }
    public static double tablespoonEUToTablespoonUK(double amount){
        return amount*TABLESPOON_EU_TO_TABLESPOON_UK;
    }
    public static double tablespoonEUToTablespoonUS(double amount){
        return amount*TABLESPOON_EU_TO_TABLESPOON_US;
    }
    public static double tablespoonEUToTeaspoonEU(double amount){
        return amount*TABLESPOON_EU_TO_TEASPOON_EU;
    }
    public static double tablespoonEUToTeaspoonUK(double amount){
        return amount*TABLESPOON_EU_TO_TEASPOON_UK;
    }
    public static double tablespoonEUToTeaspoonUS(double amount){
        return amount*TABLESPOON_EU_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM TABLESPOON (UK) ****************************************

    public static double tablespoonUKToCupUK(double amount){
        return amount*TABLESPOON_UK_TO_CUP_UK;
    }
    public static double tablespoonUKToCupUS(double amount){
        return amount*TABLESPOON_UK_TO_CUP_US;
    }
    public static double tablespoonUKToDeciliter(double amount){
        return amount*TABLESPOON_UK_TO_DECILITER;
    }
    public static double tablespoonUKToDessertspoonEU(double amount){
        return amount*TABLESPOON_UK_TO_DESSERTSPOON_EU;
    }
    public static double tablespoonUKToDessertspoonUK(double amount){
        return amount*TABLESPOON_UK_TO_DESSERTSPOON_UK;
    }
    public static double tablespoonUKToDessertspoonUS(double amount){
        return amount*TABLESPOON_UK_TO_DESSERTSPOON_US;
    }
    public static double tablespoonUKToFluidOunceUK(double amount){
        return amount*TABLESPOON_UK_TO_FLUID_OUNCE_UK;
    }
    public static double tablespoonUKToFluidOunceUS(double amount){
        return amount*TABLESPOON_UK_TO_FLUID_OUNCE_US;
    }
    public static double tablespoonUKToGallonUK(double amount){
        return amount*TABLESPOON_UK_TO_GALLON_UK;
    }
    public static double tablespoonUKToGallonUSDry(double amount){
        return amount*TABLESPOON_UK_TO_GALLON_US_DRY;
    }
    public static double tablespoonUKToGallonUS(double amount){
        return amount*TABLESPOON_UK_TO_GALLON_US;
    }
    public static double tablespoonUKToLiter(double amount){
        return amount*TABLESPOON_UK_TO_LITER;
    }
    public static double tablespoonUKToMilliliter(double amount){
        return amount*TABLESPOON_UK_TO_MILLILITER;
    }
    public static double tablespoonUKToPintUK(double amount){
        return amount*TABLESPOON_UK_TO_PINT_UK;
    }
    public static double tablespoonUKToPintUSDry(double amount){
        return amount*TABLESPOON_UK_TO_PINT_US_DRY;
    }
    public static double tablespoonUKToPintUS(double amount){
        return amount*TABLESPOON_UK_TO_PINT_US;
    }
    public static double tablespoonUKToQuartUK(double amount){
        return amount*TABLESPOON_UK_TO_QUART_UK;
    }
    public static double tablespoonUKToQuartUSDry(double amount){
        return amount*TABLESPOON_UK_TO_QUART_US_DRY;
    }
    public static double tablespoonUKToQuartUS(double amount){
        return amount*TABLESPOON_UK_TO_QUART_US;
    }
    public static double tablespoonUKToTablespoonEU(double amount){
        return amount*TABLESPOON_UK_TO_TABLESPOON_EU;
    }
    public static double tablespoonUKToTablespoonUS(double amount){
        return amount*TABLESPOON_UK_TO_TABLESPOON_US;
    }
    public static double tablespoonUKToTeaspoonEU(double amount){
        return amount*TABLESPOON_UK_TO_TEASPOON_EU;
    }
    public static double tablespoonUKToTeaspoonUK(double amount){
        return amount*TABLESPOON_UK_TO_TEASPOON_UK;
    }
    public static double tablespoonUKToTeaspoonUS(double amount){
        return amount*TABLESPOON_UK_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM TABLESPOON (US) ****************************************

    public static double tablespoonUSToCupUK(double amount){
        return amount*TABLESPOON_US_TO_CUP_UK;
    }
    public static double tablespoonUSToCupUS(double amount){
        return amount*TABLESPOON_US_TO_CUP_US;
    }
    public static double tablespoonUSToDeciliter(double amount){
        return amount*TABLESPOON_US_TO_DECILITER;
    }
    public static double tablespoonUSToDessertspoonEU(double amount){
        return amount*TABLESPOON_US_TO_DESSERTSPOON_EU;
    }
    public static double tablespoonUSToDessertspoonUK(double amount){
        return amount*TABLESPOON_US_TO_DESSERTSPOON_UK;
    }
    public static double tablespoonUSToDessertspoonUS(double amount){
        return amount*TABLESPOON_US_TO_DESSERTSPOON_US;
    }
    public static double tablespoonUSToFluidOunceUK(double amount){
        return amount*TABLESPOON_US_TO_FLUID_OUNCE_UK;
    }
    public static double tablespoonUSToFluidOunceUS(double amount){
        return amount*TABLESPOON_US_TO_FLUID_OUNCE_US;
    }
    public static double tablespoonUSToGallonUK(double amount){
        return amount*TABLESPOON_US_TO_GALLON_UK;
    }
    public static double tablespoonUSToGallonUSDry(double amount){
        return amount*TABLESPOON_US_TO_GALLON_US_DRY;
    }
    public static double tablespoonUSToGallonUS(double amount){
        return amount*TABLESPOON_US_TO_GALLON_US;
    }
    public static double tablespoonUSToLiter(double amount){
        return amount*TABLESPOON_US_TO_LITER;
    }
    public static double tablespoonUSToMilliliter(double amount){
        return amount*TABLESPOON_US_TO_MILLILITER;
    }
    public static double tablespoonUSToPintUK(double amount){
        return amount*TABLESPOON_US_TO_PINT_UK;
    }
    public static double tablespoonUSToPintUSDry(double amount){
        return amount*TABLESPOON_US_TO_PINT_US_DRY;
    }
    public static double tablespoonUSToPintUS(double amount){
        return amount*TABLESPOON_US_TO_PINT_US;
    }
    public static double tablespoonUSToQuartUK(double amount){
        return amount*TABLESPOON_US_TO_QUART_UK;
    }
    public static double tablespoonUSToQuartUSDry(double amount){
        return amount*TABLESPOON_US_TO_QUART_US_DRY;
    }
    public static double tablespoonUSToQuartUS(double amount){
        return amount*TABLESPOON_US_TO_QUART_US;
    }
    public static double tablespoonUSToTablespoonEU(double amount){
        return amount*TABLESPOON_US_TO_TABLESPOON_EU;
    }
    public static double tablespoonUSToTablespoonUK(double amount){
        return amount*TABLESPOON_US_TO_TABLESPOON_UK;
    }
    public static double tablespoonUSToTeaspoonEU(double amount){
        return amount*TABLESPOON_US_TO_TEASPOON_EU;
    }
    public static double tablespoonUSToTeaspoonUK(double amount){
        return amount*TABLESPOON_US_TO_TEASPOON_UK;
    }
    public static double tablespoonUSToTeaspoonUS(double amount){
        return amount*TABLESPOON_US_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM TEASPOON (EU) ****************************************

    public static double teaspoonEUToCupUK(double amount){
        return amount*TEASPOON_EU_TO_CUP_UK;
    }
    public static double teaspoonEUToCupUS(double amount){
        return amount*TEASPOON_EU_TO_CUP_US;
    }
    public static double teaspoonEUToDeciliter(double amount){
        return amount*TEASPOON_EU_TO_DECILITER;
    }
    public static double teaspoonEUToDessertspoonEU(double amount){
        return amount*TEASPOON_EU_TO_DESSERTSPOON_EU;
    }
    public static double teaspoonEUToDessertspoonUK(double amount){
        return amount*TEASPOON_EU_TO_DESSERTSPOON_UK;
    }
    public static double teaspoonEUToDessertspoonUS(double amount){
        return amount*TEASPOON_EU_TO_DESSERTSPOON_US;
    }
    public static double teaspoonEUToFluidOunceUK(double amount){
        return amount*TEASPOON_EU_TO_FLUID_OUNCE_UK;
    }
    public static double teaspoonEUToFluidOunceUS(double amount){
        return amount*TEASPOON_EU_TO_FLUID_OUNCE_US;
    }
    public static double teaspoonEUToGallonUK(double amount){
        return amount*TEASPOON_EU_TO_GALLON_UK;
    }
    public static double teaspoonEUToGallonUSDry(double amount){
        return amount*TEASPOON_EU_TO_GALLON_US_DRY;
    }
    public static double teaspoonEUToGallonUS(double amount){
        return amount*TEASPOON_EU_TO_GALLON_US;
    }
    public static double teaspoonEUToLiter(double amount){
        return amount*TEASPOON_EU_TO_LITER;
    }
    public static double teaspoonEUToMilliliter(double amount){
        return amount*TEASPOON_EU_TO_MILLILITER;
    }
    public static double teaspoonEUToPintUK(double amount){
        return amount*TEASPOON_EU_TO_PINT_UK;
    }
    public static double teaspoonEUToPintUSDry(double amount){
        return amount*TEASPOON_EU_TO_PINT_US_DRY;
    }
    public static double teaspoonEUToPintUS(double amount){
        return amount*TEASPOON_EU_TO_PINT_US;
    }
    public static double teaspoonEUToQuartUK(double amount){
        return amount*TEASPOON_EU_TO_QUART_UK;
    }
    public static double teaspoonEUToQuartUSDry(double amount){
        return amount*TEASPOON_EU_TO_QUART_US_DRY;
    }
    public static double teaspoonEUToQuartUS(double amount){
        return amount*TEASPOON_EU_TO_QUART_US;
    }
    public static double teaspoonEUToTablespoonEU(double amount){
        return amount*TEASPOON_EU_TO_TABLESPOON_EU;
    }
    public static double teaspoonEUToTablespoonUK(double amount){
        return amount*TEASPOON_EU_TO_TABLESPOON_UK;
    }
    public static double teaspoonEUToTablespoonUS(double amount){
        return amount*TEASPOON_EU_TO_TABLESPOON_US;
    }
    public static double teaspoonEUToTeaspoonUK(double amount){
        return amount*TEASPOON_EU_TO_TEASPOON_UK;
    }
    public static double teaspoonEUToTeaspoonUS(double amount){
        return amount*TEASPOON_EU_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM TEASPOON (UK) ****************************************

    public static double teaspoonUKToCupUK(double amount){
        return amount*TEASPOON_UK_TO_CUP_UK;
    }
    public static double teaspoonUKToCupUS(double amount){
        return amount*TEASPOON_UK_TO_CUP_US;
    }
    public static double teaspoonUKToDeciliter(double amount){
        return amount*TEASPOON_UK_TO_DECILITER;
    }
    public static double teaspoonUKToDessertspoonEU(double amount){
        return amount*TEASPOON_UK_TO_DESSERTSPOON_EU;
    }
    public static double teaspoonUKToDessertspoonUK(double amount){
        return amount*TEASPOON_UK_TO_DESSERTSPOON_UK;
    }
    public static double teaspoonUKToDessertspoonUS(double amount){
        return amount*TEASPOON_UK_TO_DESSERTSPOON_US;
    }
    public static double teaspoonUKToFluidOunceUK(double amount){
        return amount*TEASPOON_UK_TO_FLUID_OUNCE_UK;
    }
    public static double teaspoonUKToFluidOunceUS(double amount){
        return amount*TEASPOON_UK_TO_FLUID_OUNCE_US;
    }
    public static double teaspoonUKToGallonUK(double amount){
        return amount*TEASPOON_UK_TO_GALLON_UK;
    }
    public static double teaspoonUKToGallonUSDry(double amount){
        return amount*TEASPOON_UK_TO_GALLON_US_DRY;
    }
    public static double teaspoonUKToGallonUS(double amount){
        return amount*TEASPOON_UK_TO_GALLON_US;
    }
    public static double teaspoonUKToLiter(double amount){
        return amount*TEASPOON_UK_TO_LITER;
    }
    public static double teaspoonUKToMilliliter(double amount){
        return amount*TEASPOON_UK_TO_MILLILITER;
    }
    public static double teaspoonUKToPintUK(double amount){
        return amount*TEASPOON_UK_TO_PINT_UK;
    }
    public static double teaspoonUKToPintUSDry(double amount){
        return amount*TEASPOON_UK_TO_PINT_US_DRY;
    }
    public static double teaspoonUKToPintUS(double amount){
        return amount*TEASPOON_UK_TO_PINT_US;
    }
    public static double teaspoonUKToQuartUK(double amount){
        return amount*TEASPOON_UK_TO_QUART_UK;
    }
    public static double teaspoonUKToQuartUSDry(double amount){
        return amount*TEASPOON_UK_TO_QUART_US_DRY;
    }
    public static double teaspoonUKToQuartUS(double amount){
        return amount*TEASPOON_UK_TO_QUART_US;
    }
    public static double teaspoonUKToTablespoonEU(double amount){
        return amount*TEASPOON_UK_TO_TABLESPOON_EU;
    }
    public static double teaspoonUKToTablespoonUK(double amount){
        return amount*TEASPOON_UK_TO_TABLESPOON_UK;
    }
    public static double teaspoonUKToTablespoonUS(double amount){
        return amount*TEASPOON_UK_TO_TABLESPOON_US;
    }
    public static double teaspoonUKToTeaspoonEU(double amount){
        return amount*TEASPOON_UK_TO_TEASPOON_EU;
    }
    public static double teaspoonUKToTeaspoonUS(double amount){
        return amount*TEASPOON_UK_TO_TEASPOON_US;
    }

    //************************************** CONVERT FROM TEASPOON (US) ****************************************

    public static double teaspoonUSToCupUK(double amount){
        return amount*TEASPOON_US_TO_CUP_UK;
    }
    public static double teaspoonUSToCupUS(double amount){
        return amount*TEASPOON_US_TO_CUP_US;
    }
    public static double teaspoonUSToDeciliter(double amount){
        return amount*TEASPOON_US_TO_DECILITER;
    }
    public static double teaspoonUSToDessertspoonEU(double amount){
        return amount*TEASPOON_US_TO_DESSERTSPOON_EU;
    }
    public static double teaspoonUSToDessertspoonUK(double amount){
        return amount*TEASPOON_US_TO_DESSERTSPOON_UK;
    }
    public static double teaspoonUSToDessertspoonUS(double amount){
        return amount*TEASPOON_US_TO_DESSERTSPOON_US;
    }
    public static double teaspoonUSToFluidOunceUK(double amount){
        return amount*TEASPOON_US_TO_FLUID_OUNCE_UK;
    }
    public static double teaspoonUSToFluidOunceUS(double amount){
        return amount*TEASPOON_US_TO_FLUID_OUNCE_US;
    }
    public static double teaspoonUSToGallonUK(double amount){
        return amount*TEASPOON_US_TO_GALLON_UK;
    }
    public static double teaspoonUSToGallonUSDry(double amount){
        return amount*TEASPOON_US_TO_GALLON_US_DRY;
    }
    public static double teaspoonUSToGallonUS(double amount){
        return amount*TEASPOON_US_TO_GALLON_US;
    }
    public static double teaspoonUSToLiter(double amount){
        return amount*TEASPOON_US_TO_LITER;
    }
    public static double teaspoonUSToMilliliter(double amount){
        return amount*TEASPOON_US_TO_MILLILITER;
    }
    public static double teaspoonUSToPintUK(double amount){
        return amount*TEASPOON_US_TO_PINT_UK;
    }
    public static double teaspoonUSToPintUSDry(double amount){
        return amount*TEASPOON_US_TO_PINT_US_DRY;
    }
    public static double teaspoonUSToPintUS(double amount){
        return amount*TEASPOON_US_TO_PINT_US;
    }
    public static double teaspoonUSToQuartUK(double amount){
        return amount*TEASPOON_US_TO_QUART_UK;
    }
    public static double teaspoonUSToQuartUSDry(double amount){
        return amount*TEASPOON_US_TO_QUART_US_DRY;
    }
    public static double teaspoonUSToQuartUS(double amount){
        return amount*TEASPOON_US_TO_QUART_US;
    }
    public static double teaspoonUSToTablespoonEU(double amount){
        return amount*TEASPOON_US_TO_TABLESPOON_EU;
    }
    public static double teaspoonUSToTablespoonUK(double amount){
        return amount*TEASPOON_US_TO_TABLESPOON_UK;
    }
    public static double teaspoonUSToTablespoonUS(double amount){
        return amount*TEASPOON_US_TO_TABLESPOON_US;
    }
    public static double teaspoonUSToTeaspoonEU(double amount){
        return amount*TEASPOON_US_TO_TEASPOON_EU;
    }
    public static double teaspoonUSToTeaspoonUK(double amount){
        return amount*TEASPOON_US_TO_TEASPOON_UK;
    }

    //************************************** CONVERT FROM CELSIUS ****************************************

    public static double celsiusToFahrenheit(double amount){
        return (amount*9/5 + 32);
    }

    //************************************** CONVERT FROM FAHRENHEIT ****************************************

    public static double fahrenheitToCelsius(double amount){
        return ((amount - 32)*5/9);
    }
}
