package com.cookvert.util;

import java.text.DecimalFormat;

/**
 * Utility class for unit conversions. Contains multipliers and conversion methods for each unit.
 * Only contains static methods and should not be instantiated.
 * TODO add temperature units!
 * TODO final test in UI
 */
public class Converter {

    //Private constructor to prevent instantiation.
    private Converter(){}

    // MASS UNIT MULTIPLIERS:

    public static final double GRAM_TO_KILOGRAM = 0.001;
    public static final double GRAM_TO_OUNCE = 0.03527;
    public static final double GRAM_TO_POUND = 0.002205;

    public static final double KILOGRAM_TO_GRAM = 1000;
    public static final double KILOGRAM_TO_OUNCE = 35.27;
    public static final double KILOGRAM_TO_POUND = 2.205;

    public static final double OUNCE_TO_GRAM = 28.35;
    public static final double OUNCE_TO_KILOGRAM = 0.02835;
    public static final double OUNCE_TO_POUND = 0.0625;

    public static final double POUND_TO_GRAM = 453.6;
    public static final double POUND_TO_KILOGRAM = 0.4536;
    public static final double POUND_TO_OUNCE = 16;

    // VOLUME UNIT MULTIPLIERS:

    public static final double CUP_UK_TO_CUP_US = 1.201;
    public static final double CUP_UK_TO_DECILITER = 2.841;
    public static final double CUP_UK_TO_DESSERTSPOON_EU = 28.41;
    public static final double CUP_UK_TO_DESSERTSPOON_UK = 24;
    public static final double CUP_UK_TO_DESSERTSPOON_US = 28.82;
    public static final double CUP_UK_TO_FLUID_OUNCE_UK = 10;
    public static final double CUP_UK_TO_FLUID_OUNCE_US = 9.608;
    public static final double CUP_UK_TO_GALLON_UK = 0.0625;
    public static final double CUP_UK_TO_GALLON_US = 0.07505;
    public static final double CUP_UK_TO_LITER = 0.2841;
    public static final double CUP_UK_TO_MILLILITER = 284.1;
    public static final double CUP_UK_TO_PINT_UK = 0.5;
    public static final double CUP_UK_TO_PINT_US = 0.6005;
    public static final double CUP_UK_TO_QUART_UK = 0.25;
    public static final double CUP_UK_TO_QUART_US = 0.3002;
    public static final double CUP_UK_TO_TABLESPOON_EU = 18.94;
    public static final double CUP_UK_TO_TABLESPOON_UK = 16;
    public static final double CUP_UK_TO_TABLESPOON_US = 19.22;
    public static final double CUP_UK_TO_TEASPOON_EU = 56.83;
    public static final double CUP_UK_TO_TEASPOON_UK = 48;
    public static final double CUP_UK_TO_TEASPOON_US = 57.65;

    public static final double CUP_US_TO_CUP_UK = 0.8327;
    public static final double CUP_US_TO_DECILITER = 2.366;
    public static final double CUP_US_TO_DESSERTSPOON_EU = 23.66;
    public static final double CUP_US_TO_DESSERTSPOON_UK = 19.98;
    public static final double CUP_US_TO_DESSERTSPOON_US = 24;
    public static final double CUP_US_TO_FLUID_OUNCE_UK = 8.327;
    public static final double CUP_US_TO_FLUID_OUNCE_US = 8;
    public static final double CUP_US_TO_GALLON_UK = 0.05204;
    public static final double CUP_US_TO_GALLON_US = 0.0625;
    public static final double CUP_US_TO_LITER = 2.366;
    public static final double CUP_US_TO_MILLILITER = 236.6;
    public static final double CUP_US_TO_PINT_UK = 0.4163;
    public static final double CUP_US_TO_PINT_US = 0.5;
    public static final double CUP_US_TO_QUART_UK = 0.2082;
    public static final double CUP_US_TO_QUART_US = 0.25;
    public static final double CUP_US_TO_TABLESPOON_EU = 15.77;
    public static final double CUP_US_TO_TABLESPOON_UK = 13.32;
    public static final double CUP_US_TO_TABLESPOON_US = 16;
    public static final double CUP_US_TO_TEASPOON_EU = 47.32;
    public static final double CUP_US_TO_TEASPOON_UK = 39.97;
    public static final double CUP_US_TO_TEASPOON_US = 48;

    public static final double DECILITER_TO_CUP_UK = 0.352;
    public static final double DECILITER_TO_CUP_US = 0.4227;
    public static final double DECILITER_TO_DESSERTSPOON_EU = 10;
    public static final double DECILITER_TO_DESSERTSPOON_UK = 8.447;
    public static final double DECILITER_TO_DESSERTSPOON_US = 10.14;
    public static final double DECILITER_TO_FLUID_OUNCE_UK = 3.52;
    public static final double DECILITER_TO_FLUID_OUNCE_US = 3.381;
    public static final double DECILITER_TO_GALLON_UK = 0.022;
    public static final double DECILITER_TO_GALLON_US = 0.02642;
    public static final double DECILITER_TO_LITER = 0.1;
    public static final double DECILITER_TO_MILLILITER = 100;
    public static final double DECILITER_TO_PINT_UK = 0.176;
    public static final double DECILITER_TO_PINT_US = 0.2113;
    public static final double DECILITER_TO_QUART_UK = 0.08798;
    public static final double DECILITER_TO_QUART_US = 0.1057;
    public static final double DECILITER_TO_TABLESPOON_EU = 6.667;
    public static final double DECILITER_TO_TABLESPOON_UK = 5.631;
    public static final double DECILITER_TO_TABLESPOON_US = 6.763;
    public static final double DECILITER_TO_TEASPOON_EU = 20;
    public static final double DECILITER_TO_TEASPOON_UK = 16.89;
    public static final double DECILITER_TO_TEASPOON_US = 20.29;

    public static final double DESSERTSPOON_EU_TO_CUP_UK = 0.0352;
    public static final double DESSERTSPOON_EU_TO_CUP_US = 0.04227;
    public static final double DESSERTSPOON_EU_TO_DECILITER = 0.1;
    public static final double DESSERTSPOON_EU_TO_DESSERTSPOON_UK = 0.8447;
    public static final double DESSERTSPOON_EU_TO_DESSERTSPOON_US = 1.014;
    public static final double DESSERTSPOON_EU_TO_FLUID_OUNCE_UK = 0.352;
    public static final double DESSERTSPOON_EU_TO_FLUID_OUNCE_US = 0.3381;
    public static final double DESSERTSPOON_EU_TO_GALLON_UK = 0.0022;
    public static final double DESSERTSPOON_EU_TO_GALLON_US = 0.002642;
    public static final double DESSERTSPOON_EU_TO_LITER = 0.01;
    public static final double DESSERTSPOON_EU_TO_MILLILITER = 10;
    public static final double DESSERTSPOON_EU_TO_PINT_UK = 0.0176;
    public static final double DESSERTSPOON_EU_TO_PINT_US = 0.02113;
    public static final double DESSERTSPOON_EU_TO_QUART_UK = 0.008799;
    public static final double DESSERTSPOON_EU_TO_QUART_US = 0.01057;
    public static final double DESSERTSPOON_EU_TO_TABLESPOON_EU = 0.6667;
    public static final double DESSERTSPOON_EU_TO_TABLESPOON_UK = 0.5631;
    public static final double DESSERTSPOON_EU_TO_TABLESPOON_US = 0.6763;
    public static final double DESSERTSPOON_EU_TO_TEASPOON_EU = 2;
    public static final double DESSERTSPOON_EU_TO_TEASPOON_UK = 1.689;
    public static final double DESSERTSPOON_EU_TO_TEASPOON_US = 2.029;

    public static final double DESSERTSPOON_UK_TO_CUP_UK = 0.04167;
    public static final double DESSERTSPOON_UK_TO_CUP_US = 0.05004;
    public static final double DESSERTSPOON_UK_TO_DECILITER = 0.1184;
    public static final double DESSERTSPOON_UK_TO_DESSERTSPOON_EU = 1.184;
    public static final double DESSERTSPOON_UK_TO_DESSERTSPOON_US = 1.201;
    public static final double DESSERTSPOON_UK_TO_FLUID_OUNCE_UK = 0.4167;
    public static final double DESSERTSPOON_UK_TO_FLUID_OUNCE_US = 0.4003;
    public static final double DESSERTSPOON_UK_TO_GALLON_UK = 0.002604;
    public static final double DESSERTSPOON_UK_TO_GALLON_US = 0.003127;
    public static final double DESSERTSPOON_UK_TO_LITER = 0.01184;
    public static final double DESSERTSPOON_UK_TO_MILLILITER = 11.84;
    public static final double DESSERTSPOON_UK_TO_PINT_UK = 0.02083;
    public static final double DESSERTSPOON_UK_TO_PINT_US = 0.02502;
    public static final double DESSERTSPOON_UK_TO_QUART_UK = 0.01042;
    public static final double DESSERTSPOON_UK_TO_QUART_US = 0.01251;
    public static final double DESSERTSPOON_UK_TO_TABLESPOON_EU = 0.7893;
    public static final double DESSERTSPOON_UK_TO_TABLESPOON_UK = 0.6667;
    public static final double DESSERTSPOON_UK_TO_TABLESPOON_US = 0.8006;
    public static final double DESSERTSPOON_UK_TO_TEASPOON_EU = 2.368;
    public static final double DESSERTSPOON_UK_TO_TEASPOON_UK = 2;
    public static final double DESSERTSPOON_UK_TO_TEASPOON_US = 2.402;

    public static final double DESSERTSPOON_US_TO_CUP_UK = 0.0347;
    public static final double DESSERTSPOON_US_TO_CUP_US = 0.04167;
    public static final double DESSERTSPOON_US_TO_DECILITER = 0.09858;
    public static final double DESSERTSPOON_US_TO_DESSERTSPOON_EU = 0.9858;
    public static final double DESSERTSPOON_US_TO_DESSERTSPOON_UK = 0.8327;
    public static final double DESSERTSPOON_US_TO_FLUID_OUNCE_UK = 0.3469;
    public static final double DESSERTSPOON_US_TO_FLUID_OUNCE_US = 0.3333;
    public static final double DESSERTSPOON_US_TO_GALLON_UK = 0.002168;
    public static final double DESSERTSPOON_US_TO_GALLON_US = 0.002604;
    public static final double DESSERTSPOON_US_TO_LITER = 0.009858;
    public static final double DESSERTSPOON_US_TO_MILLILITER = 9.858;
    public static final double DESSERTSPOON_US_TO_PINT_UK = 0.3469;
    public static final double DESSERTSPOON_US_TO_PINT_US = 0.3333;
    public static final double DESSERTSPOON_US_TO_QUART_UK = 0.008674;
    public static final double DESSERTSPOON_US_TO_QUART_US = 0.01042;
    public static final double DESSERTSPOON_US_TO_TABLESPOON_EU = 0.6572;
    public static final double DESSERTSPOON_US_TO_TABLESPOON_UK = 0.5551;
    public static final double DESSERTSPOON_US_TO_TABLESPOON_US = 0.6667;
    public static final double DESSERTSPOON_US_TO_TEASPOON_EU = 1.972;
    public static final double DESSERTSPOON_US_TO_TEASPOON_UK = 1.665;
    public static final double DESSERTSPOON_US_TO_TEASPOON_US = 2;

    public static final double FLUID_OUNCE_UK_TO_CUP_UK = 0.1;
    public static final double FLUID_OUNCE_UK_TO_CUP_US = 0.1201;
    public static final double FLUID_OUNCE_UK_TO_DECILITER = 0.2841;
    public static final double FLUID_OUNCE_UK_TO_DESSERTSPOON_EU = 2.841;
    public static final double FLUID_OUNCE_UK_TO_DESSERTSPOON_UK = 2.4;
    public static final double FLUID_OUNCE_UK_TO_DESSERTSPOON_US = 2.882;
    public static final double FLUID_OUNCE_UK_TO_FLUID_OUNCE_US = 0.9608;
    public static final double FLUID_OUNCE_UK_TO_GALLON_UK = 0.00625;
    public static final double FLUID_OUNCE_UK_TO_GALLON_US = 0.007506;
    public static final double FLUID_OUNCE_UK_TO_LITER = 0.02841;
    public static final double FLUID_OUNCE_UK_TO_MILLILITER = 28.41;
    public static final double FLUID_OUNCE_UK_TO_PINT_UK = 0.05;
    public static final double FLUID_OUNCE_UK_TO_PINT_US = 0.06005;
    public static final double FLUID_OUNCE_UK_TO_QUART_UK = 0.025;
    public static final double FLUID_OUNCE_UK_TO_QUART_US = 0.03002;
    public static final double FLUID_OUNCE_UK_TO_TABLESPOON_EU = 1.894;
    public static final double FLUID_OUNCE_UK_TO_TABLESPOON_UK = 1.6;
    public static final double FLUID_OUNCE_UK_TO_TABLESPOON_US = 1.922;
    public static final double FLUID_OUNCE_UK_TO_TEASPOON_EU = 5.683;
    public static final double FLUID_OUNCE_UK_TO_TEASPOON_UK = 4.8;
    public static final double FLUID_OUNCE_UK_TO_TEASPOON_US = 5.765;

    public static final double FLUID_OUNCE_US_TO_CUP_UK = 0.1041;
    public static final double FLUID_OUNCE_US_TO_CUP_US = 0.125;
    public static final double FLUID_OUNCE_US_TO_DECILITER = 0.2957;
    public static final double FLUID_OUNCE_US_TO_DESSERTSPOON_EU = 2.957;
    public static final double FLUID_OUNCE_US_TO_DESSERTSPOON_UK = 2.498;
    public static final double FLUID_OUNCE_US_TO_DESSERTSPOON_US = 3;
    public static final double FLUID_OUNCE_US_TO_FLUID_OUNCE_UK = 1.041;
    public static final double FLUID_OUNCE_US_TO_GALLON_UK = 0.006505;
    public static final double FLUID_OUNCE_US_TO_GALLON_US = 0.007813;
    public static final double FLUID_OUNCE_US_TO_LITER = 0.02957;
    public static final double FLUID_OUNCE_US_TO_MILLILITER = 29.57;
    public static final double FLUID_OUNCE_US_TO_PINT_UK = 0.05204;
    public static final double FLUID_OUNCE_US_TO_PINT_US = 0.0625;
    public static final double FLUID_OUNCE_US_TO_QUART_UK = 0.02602;
    public static final double FLUID_OUNCE_US_TO_QUART_US = 0.03125;
    public static final double FLUID_OUNCE_US_TO_TABLESPOON_EU = 1.972;
    public static final double FLUID_OUNCE_US_TO_TABLESPOON_UK = 1.665;
    public static final double FLUID_OUNCE_US_TO_TABLESPOON_US = 2;
    public static final double FLUID_OUNCE_US_TO_TEASPOON_EU = 5.915;
    public static final double FLUID_OUNCE_US_TO_TEASPOON_UK = 4.996;
    public static final double FLUID_OUNCE_US_TO_TEASPOON_US = 6;

    public static final double GALLON_UK_TO_CUP_UK = 16;
    public static final double GALLON_UK_TO_CUP_US = 19.22;
    public static final double GALLON_UK_TO_DECILITER = 1000;
    public static final double GALLON_UK_TO_DESSERTSPOON_EU = 454.6;
    public static final double GALLON_UK_TO_DESSERTSPOON_UK = 384;
    public static final double GALLON_UK_TO_DESSERTSPOON_US = 461.1;
    public static final double GALLON_UK_TO_FLUID_OUNCE_UK = 160;
    public static final double GALLON_UK_TO_FLUID_OUNCE_US = 153.7;
    public static final double GALLON_UK_TO_GALLON_US = 1.201;
    public static final double GALLON_UK_TO_LITER = 4.546;
    public static final double GALLON_UK_TO_MILLILITER = 4546;
    public static final double GALLON_UK_TO_PINT_UK = 8;
    public static final double GALLON_UK_TO_PINT_US = 9.608;
    public static final double GALLON_UK_TO_QUART_UK = 4;
    public static final double GALLON_UK_TO_QUART_US = 4.804;
    public static final double GALLON_UK_TO_TABLESPOON_EU = 303.1;
    public static final double GALLON_UK_TO_TABLESPOON_UK = 256;
    public static final double GALLON_UK_TO_TABLESPOON_US = 307.4;
    public static final double GALLON_UK_TO_TEASPOON_EU = 909.2;
    public static final double GALLON_UK_TO_TEASPOON_UK = 768;
    public static final double GALLON_UK_TO_TEASPOON_US = 922.3;

    public static final double GALLON_US_TO_CUP_UK = 13.32;
    public static final double GALLON_US_TO_CUP_US = 16;
    public static final double GALLON_US_TO_DECILITER = 37.85;
    public static final double GALLON_US_TO_DESSERTSPOON_EU = 378.5;
    public static final double GALLON_US_TO_DESSERTSPOON_UK = 319.7;
    public static final double GALLON_US_TO_DESSERTSPOON_US = 384;
    public static final double GALLON_US_TO_FLUID_OUNCE_UK = 133.2;
    public static final double GALLON_US_TO_FLUID_OUNCE_US = 128;
    public static final double GALLON_US_TO_GALLON_UK = 0.8327;
    public static final double GALLON_US_TO_LITER = 3.785;
    public static final double GALLON_US_TO_MILLILITER = 3785;
    public static final double GALLON_US_TO_PINT_UK = 6.661;
    public static final double GALLON_US_TO_PINT_US = 8;
    public static final double GALLON_US_TO_QUART_UK = 3.331;
    public static final double GALLON_US_TO_QUART_US = 4;
    public static final double GALLON_US_TO_TABLESPOON_EU = 252.4;
    public static final double GALLON_US_TO_TABLESPOON_UK = 213.2;
    public static final double GALLON_US_TO_TABLESPOON_US = 256;
    public static final double GALLON_US_TO_TEASPOON_EU = 757.1;
    public static final double GALLON_US_TO_TEASPOON_UK = 639.5;
    public static final double GALLON_US_TO_TEASPOON_US = 768;

    public static final double LITER_TO_CUP_UK = 3.52;
    public static final double LITER_TO_CUP_US = 4.227;
    public static final double LITER_TO_DECILITER = 10;
    public static final double LITER_TO_DESSERTSPOON_EU = 100;
    public static final double LITER_TO_DESSERTSPOON_UK = 84.47;
    public static final double LITER_TO_DESSERTSPOON_US = 101.4;
    public static final double LITER_TO_FLUID_OUNCE_UK = 35.2;
    public static final double LITER_TO_FLUID_OUNCE_US = 33.81;
    public static final double LITER_TO_GALLON_UK = 0.22;
    public static final double LITER_TO_GALLON_US = 0.2642;
    public static final double LITER_TO_MILLILITER = 1000;
    public static final double LITER_TO_PINT_UK = 1.76;
    public static final double LITER_TO_PINT_US = 2.113;
    public static final double LITER_TO_QUART_UK = 0.8799;
    public static final double LITER_TO_QUART_US = 1.057;
    public static final double LITER_TO_TABLESPOON_EU = 66.67;
    public static final double LITER_TO_TABLESPOON_UK = 56.31;
    public static final double LITER_TO_TABLESPOON_US = 67.63;
    public static final double LITER_TO_TEASPOON_EU = 200;
    public static final double LITER_TO_TEASPOON_UK = 168.9;
    public static final double LITER_TO_TEASPOON_US = 202.9;

    public static final double MILLILITER_TO_CUP_UK = 0.00352;
    public static final double MILLILITER_TO_CUP_US = 0.004227;
    public static final double MILLILITER_TO_DECILITER = 0.01;
    public static final double MILLILITER_TO_DESSERTSPOON_EU = 0.1;
    public static final double MILLILITER_TO_DESSERTSPOON_UK = 0.08447;
    public static final double MILLILITER_TO_DESSERTSPOON_US = 0.1014;
    public static final double MILLILITER_TO_FLUID_OUNCE_UK = 0.0352;
    public static final double MILLILITER_TO_FLUID_OUNCE_US = 0.03381;
    public static final double MILLILITER_TO_GALLON_UK = 0.00022;
    public static final double MILLILITER_TO_GALLON_US = 0.0002642;
    public static final double MILLILITER_TO_LITER = 0.001;
    public static final double MILLILITER_TO_PINT_UK = 0.00176;
    public static final double MILLILITER_TO_PINT_US = 0.002113;
    public static final double MILLILITER_TO_QUART_UK = 0.0008799;
    public static final double MILLILITER_TO_QUART_US = 0.001057;
    public static final double MILLILITER_TO_TABLESPOON_EU = 0.06667;
    public static final double MILLILITER_TO_TABLESPOON_UK = 0.05631;
    public static final double MILLILITER_TO_TABLESPOON_US = 0.06763;
    public static final double MILLILITER_TO_TEASPOON_EU = 0.2;
    public static final double MILLILITER_TO_TEASPOON_UK = 0.1689;
    public static final double MILLILITER_TO_TEASPOON_US = 0.2029;

    public static final double PINT_UK_TO_CUP_UK = 2;
    public static final double PINT_UK_TO_CUP_US = 2.402;
    public static final double PINT_UK_TO_DECILITER = 5.683;
    public static final double PINT_UK_TO_DESSERTSPOON_EU = 56.83;
    public static final double PINT_UK_TO_DESSERTSPOON_UK = 48;
    public static final double PINT_UK_TO_DESSERTSPOON_US = 57.65;
    public static final double PINT_UK_TO_FLUID_OUNCE_UK = 20;
    public static final double PINT_UK_TO_FLUID_OUNCE_US = 19.22;
    public static final double PINT_UK_TO_GALLON_UK = 0.125;
    public static final double PINT_UK_TO_GALLON_US = 0.1501;
    public static final double PINT_UK_TO_LITER = 0.5683;
    public static final double PINT_UK_TO_MILLILITER = 568.3;
    public static final double PINT_UK_TO_PINT_US = 1.201;
    public static final double PINT_UK_TO_QUART_UK = 0.5;
    public static final double PINT_UK_TO_QUART_US = 0.6005;
    public static final double PINT_UK_TO_TABLESPOON_EU = 37.88;
    public static final double PINT_UK_TO_TABLESPOON_UK = 32;
    public static final double PINT_UK_TO_TABLESPOON_US = 38.43;
    public static final double PINT_UK_TO_TEASPOON_EU = 113.7;
    public static final double PINT_UK_TO_TEASPOON_UK = 96;
    public static final double PINT_UK_TO_TEASPOON_US = 115.3;

    public static final double PINT_US_TO_CUP_UK = 1.665;
    public static final double PINT_US_TO_CUP_US = 2;
    public static final double PINT_US_TO_DECILITER = 4.732;
    public static final double PINT_US_TO_DESSERTSPOON_EU = 47.32;
    public static final double PINT_US_TO_DESSERTSPOON_UK = 39.97;
    public static final double PINT_US_TO_DESSERTSPOON_US = 48;
    public static final double PINT_US_TO_FLUID_OUNCE_UK = 16.65;
    public static final double PINT_US_TO_FLUID_OUNCE_US = 16;
    public static final double PINT_US_TO_GALLON_UK = 0.1041;
    public static final double PINT_US_TO_GALLON_US = 0.125;
    public static final double PINT_US_TO_LITER = 0.4732;
    public static final double PINT_US_TO_MILLILITER = 473.2;
    public static final double PINT_US_TO_PINT_UK = 0.8327;
    public static final double PINT_US_TO_QUART_UK = 0.4163;
    public static final double PINT_US_TO_QUART_US = 0.8327;
    public static final double PINT_US_TO_TABLESPOON_EU = 31.55;
    public static final double PINT_US_TO_TABLESPOON_UK = 26.65;
    public static final double PINT_US_TO_TABLESPOON_US = 32;
    public static final double PINT_US_TO_TEASPOON_EU = 94.64;
    public static final double PINT_US_TO_TEASPOON_UK = 79.94;
    public static final double PINT_US_TO_TEASPOON_US = 96;

    public static final double QUART_UK_TO_CUP_UK = 4;
    public static final double QUART_UK_TO_CUP_US = 4.804;
    public static final double QUART_UK_TO_DECILITER = 11.37;
    public static final double QUART_UK_TO_DESSERTSPOON_EU = 113.7;
    public static final double QUART_UK_TO_DESSERTSPOON_UK = 96;
    public static final double QUART_UK_TO_DESSERTSPOON_US = 115.3;
    public static final double QUART_UK_TO_FLUID_OUNCE_UK = 40;
    public static final double QUART_UK_TO_FLUID_OUNCE_US = 38.43;
    public static final double QUART_UK_TO_GALLON_UK = 0.25;
    public static final double QUART_UK_TO_GALLON_US = 0.3002;
    public static final double QUART_UK_TO_LITER = 1.137;
    public static final double QUART_UK_TO_MILLILITER = 1137;
    public static final double QUART_UK_TO_PINT_UK = 2;
    public static final double QUART_UK_TO_PINT_US = 2.402;
    public static final double QUART_UK_TO_QUART_US = 1.201;
    public static final double QUART_UK_TO_TABLESPOON_EU = 75.77;
    public static final double QUART_UK_TO_TABLESPOON_UK = 64;
    public static final double QUART_UK_TO_TABLESPOON_US = 76.86;
    public static final double QUART_UK_TO_TEASPOON_EU = 227.3;
    public static final double QUART_UK_TO_TEASPOON_UK = 192;
    public static final double QUART_UK_TO_TEASPOON_US = 230.6;

    public static final double QUART_US_TO_CUP_UK = 3.331;
    public static final double QUART_US_TO_CUP_US = 4;
    public static final double QUART_US_TO_DECILITER = 9.464;
    public static final double QUART_US_TO_DESSERTSPOON_EU = 94.64;
    public static final double QUART_US_TO_DESSERTSPOON_UK = 79.94;
    public static final double QUART_US_TO_DESSERTSPOON_US = 96;
    public static final double QUART_US_TO_FLUID_OUNCE_UK = 33.31;
    public static final double QUART_US_TO_FLUID_OUNCE_US = 32;
    public static final double QUART_US_TO_GALLON_UK = 0.2082;
    public static final double QUART_US_TO_GALLON_US = 0.25;
    public static final double QUART_US_TO_LITER = 0.9464;
    public static final double QUART_US_TO_MILLILITER = 946.4;
    public static final double QUART_US_TO_PINT_UK = 1.665;
    public static final double QUART_US_TO_PINT_US = 2;
    public static final double QUART_US_TO_QUART_UK = 0.8327;
    public static final double QUART_US_TO_TABLESPOON_EU = 63.1;
    public static final double QUART_US_TO_TABLESPOON_UK = 53.29;
    public static final double QUART_US_TO_TABLESPOON_US = 64;
    public static final double QUART_US_TO_TEASPOON_EU = 189.3;
    public static final double QUART_US_TO_TEASPOON_UK = 159.9;
    public static final double QUART_US_TO_TEASPOON_US = 192;

    public static final double TABLESPOON_EU_TO_CUP_UK = 0.05279;
    public static final double TABLESPOON_EU_TO_CUP_US = 0.0634;
    public static final double TABLESPOON_EU_TO_DECILITER = 0.15;
    public static final double TABLESPOON_EU_TO_DESSERTSPOON_EU = 1.5;
    public static final double TABLESPOON_EU_TO_DESSERTSPOON_UK = 1.267;
    public static final double TABLESPOON_EU_TO_DESSERTSPOON_US = 1.522;
    public static final double TABLESPOON_EU_TO_FLUID_OUNCE_UK = 0.5279;
    public static final double TABLESPOON_EU_TO_FLUID_OUNCE_US = 0.5072;
    public static final double TABLESPOON_EU_TO_GALLON_UK = 0.0033;
    public static final double TABLESPOON_EU_TO_GALLON_US = 0.003963;
    public static final double TABLESPOON_EU_TO_LITER = 0.015;
    public static final double TABLESPOON_EU_TO_MILLILITER = 15;
    public static final double TABLESPOON_EU_TO_PINT_UK = 0.0264;
    public static final double TABLESPOON_EU_TO_PINT_US = 0.0317;
    public static final double TABLESPOON_EU_TO_QUART_UK = 0.0132;
    public static final double TABLESPOON_EU_TO_QUART_US = 0.01585;
    public static final double TABLESPOON_EU_TO_TABLESPOON_UK = 0.8447;
    public static final double TABLESPOON_EU_TO_TABLESPOON_US = 1.014;
    public static final double TABLESPOON_EU_TO_TEASPOON_EU = 3;
    public static final double TABLESPOON_EU_TO_TEASPOON_UK = 2.534;
    public static final double TABLESPOON_EU_TO_TEASPOON_US = 3.043;

    public static final double TABLESPOON_UK_TO_CUP_UK = 0.0625;
    public static final double TABLESPOON_UK_TO_CUP_US = 0.07506;
    public static final double TABLESPOON_UK_TO_DECILITER = 0.1776;
    public static final double TABLESPOON_UK_TO_DESSERTSPOON_EU = 1.776;
    public static final double TABLESPOON_UK_TO_DESSERTSPOON_UK = 1.5;
    public static final double TABLESPOON_UK_TO_DESSERTSPOON_US = 1.801;
    public static final double TABLESPOON_UK_TO_FLUID_OUNCE_UK = 0.625;
    public static final double TABLESPOON_UK_TO_FLUID_OUNCE_US = 0.6005;
    public static final double TABLESPOON_UK_TO_GALLON_UK = 0.003906;
    public static final double TABLESPOON_UK_TO_GALLON_US = 0.004691;
    public static final double TABLESPOON_UK_TO_LITER = 0.01776;
    public static final double TABLESPOON_UK_TO_MILLILITER = 17.76;
    public static final double TABLESPOON_UK_TO_PINT_UK = 0.03125;
    public static final double TABLESPOON_UK_TO_PINT_US = 0.03753;
    public static final double TABLESPOON_UK_TO_QUART_UK = 0.01563;
    public static final double TABLESPOON_UK_TO_QUART_US = 0.01876;
    public static final double TABLESPOON_UK_TO_TABLESPOON_EU = 1.184;
    public static final double TABLESPOON_UK_TO_TABLESPOON_US = 1.201;
    public static final double TABLESPOON_UK_TO_TEASPOON_EU = 3.552;
    public static final double TABLESPOON_UK_TO_TEASPOON_UK = 3;
    public static final double TABLESPOON_UK_TO_TEASPOON_US = 3.603;

    public static final double TABLESPOON_US_TO_CUP_UK = 0.0520;
    public static final double TABLESPOON_US_TO_CUP_US = 0.0634;
    public static final double TABLESPOON_US_TO_DECILITER = 0.1479;
    public static final double TABLESPOON_US_TO_DESSERTSPOON_EU = 1.479;
    public static final double TABLESPOON_US_TO_DESSERTSPOON_UK = 1.249;
    public static final double TABLESPOON_US_TO_DESSERTSPOON_US = 1.5;
    public static final double TABLESPOON_US_TO_FLUID_OUNCE_UK = 0.5204;
    public static final double TABLESPOON_US_TO_FLUID_OUNCE_US = 0.5;
    public static final double TABLESPOON_US_TO_GALLON_UK = 0.003253;
    public static final double TABLESPOON_US_TO_GALLON_US = 0.003906;
    public static final double TABLESPOON_US_TO_LITER = 0.01479;
    public static final double TABLESPOON_US_TO_MILLILITER = 14.79;
    public static final double TABLESPOON_US_TO_PINT_UK = 0.02602;
    public static final double TABLESPOON_US_TO_PINT_US = 0.03125;
    public static final double TABLESPOON_US_TO_QUART_UK = 0.01301;
    public static final double TABLESPOON_US_TO_QUART_US = 0.01563;
    public static final double TABLESPOON_US_TO_TABLESPOON_EU = 0.9858;
    public static final double TABLESPOON_US_TO_TABLESPOON_UK = 0.8327;
    public static final double TABLESPOON_US_TO_TEASPOON_EU = 2.957;
    public static final double TABLESPOON_US_TO_TEASPOON_UK = 2.498;
    public static final double TABLESPOON_US_TO_TEASPOON_US = 3;

    public static final double TEASPOON_EU_TO_CUP_UK = 0.0176;
    public static final double TEASPOON_EU_TO_CUP_US = 0.02113;
    public static final double TEASPOON_EU_TO_DECILITER = 0.05;
    public static final double TEASPOON_EU_TO_DESSERTSPOON_EU = 0.5;
    public static final double TEASPOON_EU_TO_DESSERTSPOON_UK = 0.4223;
    public static final double TEASPOON_EU_TO_DESSERTSPOON_US = 0.5072;
    public static final double TEASPOON_EU_TO_FLUID_OUNCE_UK = 0.176;
    public static final double TEASPOON_EU_TO_FLUID_OUNCE_US = 0.1691;
    public static final double TEASPOON_EU_TO_GALLON_UK = 0.0011;
    public static final double TEASPOON_EU_TO_GALLON_US = 0.001321;
    public static final double TEASPOON_EU_TO_LITER = 0.005;
    public static final double TEASPOON_EU_TO_MILLILITER = 5;
    public static final double TEASPOON_EU_TO_PINT_UK = 0.008799;
    public static final double TEASPOON_EU_TO_PINT_US = 0.01057;
    public static final double TEASPOON_EU_TO_QUART_UK = 0.0044;
    public static final double TEASPOON_EU_TO_QUART_US = 0.005283;
    public static final double TEASPOON_EU_TO_TABLESPOON_EU = 0.3333;
    public static final double TEASPOON_EU_TO_TABLESPOON_UK = 0.2816;
    public static final double TEASPOON_EU_TO_TABLESPOON_US = 0.3381;
    public static final double TEASPOON_EU_TO_TEASPOON_UK = 0.8447;
    public static final double TEASPOON_EU_TO_TEASPOON_US = 1.014;

    public static final double TEASPOON_UK_TO_CUP_UK = 0.02083;
    public static final double TEASPOON_UK_TO_CUP_US = 0.02502;
    public static final double TEASPOON_UK_TO_DECILITER = 0.05919;
    public static final double TEASPOON_UK_TO_DESSERTSPOON_EU = 0.5919;
    public static final double TEASPOON_UK_TO_DESSERTSPOON_UK = 0.5;
    public static final double TEASPOON_UK_TO_DESSERTSPOON_US = 0.6005;
    public static final double TEASPOON_UK_TO_FLUID_OUNCE_UK = 0.2083;
    public static final double TEASPOON_UK_TO_FLUID_OUNCE_US = 0.2002;
    public static final double TEASPOON_UK_TO_GALLON_UK = 0.001302;
    public static final double TEASPOON_UK_TO_GALLON_US = 0.001564;
    public static final double TEASPOON_UK_TO_LITER = 0.005919;
    public static final double TEASPOON_UK_TO_MILLILITER = 5.919;
    public static final double TEASPOON_UK_TO_PINT_UK = 0.01042;
    public static final double TEASPOON_UK_TO_PINT_US = 0.01251;
    public static final double TEASPOON_UK_TO_QUART_UK = 0.005208;
    public static final double TEASPOON_UK_TO_QUART_US = 0.006255;
    public static final double TEASPOON_UK_TO_TABLESPOON_EU = 0.3946;
    public static final double TEASPOON_UK_TO_TABLESPOON_UK = 0.3333;
    public static final double TEASPOON_UK_TO_TABLESPOON_US = 0.4003;
    public static final double TEASPOON_UK_TO_TEASPOON_EU = 1.184;
    public static final double TEASPOON_UK_TO_TEASPOON_US = 1.201;

    public static final double TEASPOON_US_TO_CUP_UK = 0.01735;
    public static final double TEASPOON_US_TO_CUP_US = 0.02083;
    public static final double TEASPOON_US_TO_DECILITER = 0.04929;
    public static final double TEASPOON_US_TO_DESSERTSPOON_EU = 0.4929;
    public static final double TEASPOON_US_TO_DESSERTSPOON_UK = 0.4163;
    public static final double TEASPOON_US_TO_DESSERTSPOON_US = 0.5;
    public static final double TEASPOON_US_TO_FLUID_OUNCE_UK = 0.1735;
    public static final double TEASPOON_US_TO_FLUID_OUNCE_US = 0.1667;
    public static final double TEASPOON_US_TO_GALLON_UK = 0.001084;
    public static final double TEASPOON_US_TO_GALLON_US = 0.001302;
    public static final double TEASPOON_US_TO_LITER = 0.004929;
    public static final double TEASPOON_US_TO_MILLILITER = 4.929;
    public static final double TEASPOON_US_TO_PINT_UK = 0.008674;
    public static final double TEASPOON_US_TO_PINT_US = 0.01042;
    public static final double TEASPOON_US_TO_QUART_UK = 0.004337;
    public static final double TEASPOON_US_TO_QUART_US = 0.005208;
    public static final double TEASPOON_US_TO_TABLESPOON_EU = 0.3286;
    public static final double TEASPOON_US_TO_TABLESPOON_UK = 0.2776;
    public static final double TEASPOON_US_TO_TABLESPOON_US = 0.3333;
    public static final double TEASPOON_US_TO_TEASPOON_EU = 0.9858;
    public static final double TEASPOON_US_TO_TEASPOON_UK = 0.8327;


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
    public static double cupUKToPintUS(double amount){
        return amount*CUP_UK_TO_PINT_US;
    }
    public static double cupUKToQuartUK(double amount){
        return amount*CUP_UK_TO_QUART_UK;
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
    public static double cupUSToPintUS(double amount){
        return amount*CUP_US_TO_PINT_US;
    }
    public static double cupUSToQuartUK(double amount){
        return amount*CUP_US_TO_QUART_UK;
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
    public static double deciliterToPintUS(double amount){
        return amount*DECILITER_TO_PINT_US;
    }
    public static double deciliterToQuartUK(double amount){
        return amount*DECILITER_TO_QUART_UK;
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
    public static double dessertspoonEUToPintUS(double amount){
        return amount*DESSERTSPOON_EU_TO_PINT_US;
    }
    public static double dessertspoonEUToQuartUK(double amount){
        return amount*DESSERTSPOON_EU_TO_QUART_UK;
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
    public static double dessertspoonUKToPintUS(double amount){
        return amount*DESSERTSPOON_UK_TO_PINT_US;
    }
    public static double dessertspoonUKToQuartUK(double amount){
        return amount*DESSERTSPOON_UK_TO_QUART_UK;
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
    public static double dessertspoonUSToPintUS(double amount){
        return amount*DESSERTSPOON_US_TO_PINT_US;
    }
    public static double dessertspoonUSToQuartUK(double amount){
        return amount*DESSERTSPOON_US_TO_QUART_UK;
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
    public static double fluidOunceUKToPintUS(double amount){
        return amount*FLUID_OUNCE_UK_TO_PINT_US;
    }
    public static double fluidOunceUKToQuartUK(double amount){
        return amount*FLUID_OUNCE_UK_TO_QUART_UK;
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
    public static double fluidOunceUSToPintUS(double amount){
        return amount*FLUID_OUNCE_US_TO_PINT_US;
    }
    public static double fluidOunceUSToQuartUK(double amount){
        return amount*FLUID_OUNCE_US_TO_QUART_UK;
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
    public static double gallonUKToPintUS(double amount){
        return amount*GALLON_UK_TO_PINT_US;
    }
    public static double gallonUKToQuartUK(double amount){
        return amount*GALLON_UK_TO_QUART_UK;
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

    //************************************** CONVERT FROM GALLON (US) *********************************************

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
    public static double gallonUSToLiter(double amount){
        return amount*GALLON_US_TO_LITER;
    }
    public static double gallonUSToMilliliter(double amount){
        return amount*GALLON_US_TO_MILLILITER;
    }
    public static double gallonUSToPintUK(double amount){
        return amount*GALLON_US_TO_PINT_UK;
    }
    public static double gallonUSToPintUS(double amount){
        return amount*GALLON_US_TO_PINT_US;
    }
    public static double gallonUSToQuartUK(double amount){
        return amount*GALLON_US_TO_QUART_UK;
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
    public static double literToGallonUS(double amount){
        return amount*LITER_TO_GALLON_US;
    }
    public static double literToMilliliter(double amount){
        return amount*LITER_TO_MILLILITER;
    }
    public static double literToPintUK(double amount){
        return amount*LITER_TO_PINT_UK;
    }
    public static double literToPintUS(double amount){
        return amount*LITER_TO_PINT_US;
    }
    public static double literToQuartUK(double amount){
        return amount*LITER_TO_QUART_UK;
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
    public static double milliliterToGallonUS(double amount){
        return amount*MILLILITER_TO_GALLON_US;
    }
    public static double milliliterToLiter(double amount){
        return amount*MILLILITER_TO_LITER;
    }
    public static double milliliterToPintUK(double amount){
        return amount*MILLILITER_TO_PINT_UK;
    }
    public static double milliliterToPintUS(double amount){
        return amount*MILLILITER_TO_PINT_US;
    }
    public static double milliliterToQuartUK(double amount){
        return amount*MILLILITER_TO_QUART_UK;
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
    public static double pintUKToGallonUS(double amount){
        return amount*PINT_UK_TO_GALLON_US;
    }
    public static double pintUKToLiter(double amount){
        return amount*PINT_UK_TO_LITER;
    }
    public static double pintUKToMilliliter(double amount){
        return amount*PINT_UK_TO_MILLILITER;
    }
    public static double pintUKToPintUS(double amount){
        return amount*PINT_UK_TO_PINT_US;
    }
    public static double pintUKToQuartUK(double amount){
        return amount*PINT_UK_TO_QUART_UK;
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

    //************************************** CONVERT FROM PINT (US) ***********************************************

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
    public static double pintUSToQuartUK(double amount){
        return amount*PINT_US_TO_QUART_UK;
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
    public static double quartUKToPintUS(double amount){
        return amount*QUART_UK_TO_PINT_US;
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

    //************************************** CONVERT FROM QUART (US) **********************************************

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
    public static double quartUSToPintUS(double amount){
        return amount*QUART_US_TO_PINT_US;
    }
    public static double quartUSToQuartUK(double amount){
        return amount*QUART_US_TO_QUART_UK;
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
    public static double tablespoonEUToPintUS(double amount){
        return amount*TABLESPOON_EU_TO_PINT_US;
    }
    public static double tablespoonEUToQuartUK(double amount){
        return amount*TABLESPOON_EU_TO_QUART_UK;
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
    public static double tablespoonUKToPintUS(double amount){
        return amount*TABLESPOON_UK_TO_PINT_US;
    }
    public static double tablespoonUKToQuartUK(double amount){
        return amount*TABLESPOON_UK_TO_QUART_UK;
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
    public static double tablespoonUSToPintUS(double amount){
        return amount*TABLESPOON_US_TO_PINT_US;
    }
    public static double tablespoonUSToQuartUK(double amount){
        return amount*TABLESPOON_US_TO_QUART_UK;
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
    public static double teaspoonEUToPintUS(double amount){
        return amount*TEASPOON_EU_TO_PINT_US;
    }
    public static double teaspoonEUToQuartUK(double amount){
        return amount*TEASPOON_EU_TO_QUART_UK;
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
    public static double teaspoonUKToPintUS(double amount){
        return amount*TEASPOON_UK_TO_PINT_US;
    }
    public static double teaspoonUKToQuartUK(double amount){
        return amount*TEASPOON_UK_TO_QUART_UK;
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
    public static double teaspoonUSToPintUS(double amount){
        return amount*TEASPOON_US_TO_PINT_US;
    }
    public static double teaspoonUSToQuartUK(double amount){
        return amount*TEASPOON_US_TO_QUART_UK;
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
}
