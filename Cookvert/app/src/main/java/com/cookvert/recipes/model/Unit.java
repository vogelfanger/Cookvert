package com.cookvert.recipes.model;

import com.cookvert.R;
import com.cookvert.util.Converter;

/**
 *
 */
public enum Unit {

    GRAM{
        private final int unitKey = 1;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int massListPosition() {
            return 0;
        }

        @Override
        public int wholeListPosition() {
            return 11;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_gram;
        }

        @Override
        public boolean isMassUnit() {
            return true;
        }

        // CONVERSION METHODS:

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromGram(amount);
        }
        @Override
        public double convertFromGram(double amount){
            return amount;
        }
        @Override
        public double convertFromKilogram(double amount){
            return Converter.kilogramToGram(amount);
        }
        @Override
        public double convertFromOunce(double amount){
            return Converter.ounceToGram(amount);
        }
        @Override
        public double convertFromPound(double amount){
            return Converter.poundToGram(amount);
        }
    },

    //**************************************** KILOGRAM **************************************************
    KILOGRAM{

        private final int unitKey = 2;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int massListPosition() {
            return 1;
        }

        @Override
        public int wholeListPosition() {
            return 12;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_kilogram;
        }

        @Override
        public boolean isMassUnit() {
            return true;
        }

        // CONVERSION METHODS:

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromKilogram(amount);
        }
        @Override
        public double convertFromGram(double amount){
            return Converter.gramToKilogram(amount);
        }
        @Override
        public double convertFromKilogram(double amount){
            return amount;
        }
        @Override
        public double convertFromOunce(double amount){
            return Converter.ounceToKilogram(amount);
        }
        @Override
        public double convertFromPound(double amount){
            return Converter.poundToKilogram(amount);
        }
    },

    //**************************************** OUNCE **************************************************

    OUNCE{

        private final int unitKey = 3;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int massListPosition() {
            return 2;
        }

        @Override
        public int wholeListPosition() {
            return 15;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_ounce;
        }

        @Override
        public boolean isMassUnit() {
            return true;
        }

        // CONVERSION METHODS:

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromOunce(amount);
        }
        @Override
        public double convertFromGram(double amount){
            return Converter.gramToOunce(amount);
        }
        @Override
        public double convertFromKilogram(double amount){
            return Converter.kilogramToOunce(amount);
        }
        @Override
        public double convertFromOunce(double amount){
            return amount;
        }
        @Override
        public double convertFromPound(double amount){
            return Converter.poundToOunce(amount);
        }
    },

    //**************************************** POUND **************************************************

    POUND {

        private final int unitKey = 4;

        @Override
        public int getUnitKey() {
            return unitKey;
        }

        @Override
        public int massListPosition() {
            return 3;
        }

        @Override
        public int wholeListPosition() {
            return 20;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_pound;
        }

        @Override
        public boolean isMassUnit() {
            return true;
        }

        // CONVERSION METHODS:

        @Override
        public double convert(Unit target, double amount) {
            return target.convertFromPound(amount);
        }
        @Override
        public double convertFromGram(double amount) {
            return Converter.gramToPound(amount);
        }
        @Override
        public double convertFromKilogram(double amount) {
            return Converter.kilogramToPound(amount);
        }
        @Override
        public double convertFromOunce(double amount) {
            return Converter.ounceToPound(amount);
        }
        @Override
        public double convertFromPound(double amount) {
            return amount;
        }
    },

    //**************************************** CUP (UK) **************************************************

    CUP_UK {

        private final int unitKey = 5;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 0;
        }

        @Override
        public int wholeListPosition() {
            return 0;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_cup_uk;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS:

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromCupUK(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return amount;
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToCupUK(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToCupUK(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToCupUK(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToCupUK(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToCupUK(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToCupUK(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToCupUK(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToCupUK(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToCupUK(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToCupUK(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToCupUK(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToCupUK(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToCupUK(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToCupUK(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToCupUK(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToCupUK(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToCupUK(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToCupUK(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToCupUK(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToCupUK(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToCupUK(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToCupUK(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToCupUK(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToCupUK(amount);
        }
    },

    //**************************************** CUP (US) **************************************************

    CUP_US {

        private final int unitKey = 6;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 1;
        }

        @Override
        public int wholeListPosition() {
            return 1;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_cup_us;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromCupUS(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToCupUS(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return amount;
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToCupUS(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToCupUS(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToCupUS(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToCupUS(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToCupUS(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToCupUS(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToCupUS(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToCupUS(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToCupUS(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToCupUS(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToCupUS(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToCupUS(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToCupUS(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToCupUS(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToCupUS(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToCupUS(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToCupUS(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToCupUS(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToCupUS(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToCupUS(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToCupUS(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToCupUS(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToCupUS(amount);
        }
    },

    //**************************************** DECILITER **************************************************

    DECILITER {

        private final int unitKey = 7;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 2;
        }

        @Override
        public int wholeListPosition() {
            return 2;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_deciliter;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromDeciliter(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToDeciliter(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToDeciliter(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return amount;
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToDeciliter(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToDeciliter(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToDeciliter(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToDeciliter(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToDeciliter(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToDeciliter(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToDeciliter(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToDeciliter(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToDeciliter(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToDeciliter(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToDeciliter(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToDeciliter(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToDeciliter(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToDeciliter(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToDeciliter(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToDeciliter(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToDeciliter(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToDeciliter(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToDeciliter(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToDeciliter(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToDeciliter(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToDeciliter(amount);
        }
    },

    //**************************************** DESSERTSPOON (EU) **************************************************

    DESSERTSPOON_EU {

        private final int unitKey = 8;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 3;
        }

        @Override
        public int wholeListPosition() {
            return 3;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_dessertspoon_eu;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromDessertspoonEU(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToDessertspoonEU(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToDessertspoonEU(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToDessertspoonEU(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return amount;
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToDessertspoonEU(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToDessertspoonEU(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToDessertspoonEU(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToDessertspoonEU(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToDessertspoonEU(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToDessertspoonEU(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToDessertspoonEU(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToDessertspoonEU(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToDessertspoonEU(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToDessertspoonEU(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToDessertspoonEU(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToDessertspoonEU(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToDessertspoonEU(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToDessertspoonEU(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToDessertspoonEU(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToDessertspoonEU(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToDessertspoonEU(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToDessertspoonEU(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToDessertspoonEU(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToDessertspoonEU(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToDessertspoonEU(amount);
        }
    },

    //**************************************** DESSERTSPOON (UK) **************************************************

    DESSERTSPOON_UK {

        private final int unitKey = 9;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 4;
        }

        @Override
        public int wholeListPosition() {
            return 4;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_dessertspoon_uk;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromDessertspoonUK(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToDessertspoonUK(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToDessertspoonUK(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToDessertspoonUK(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToDessertspoonUK(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return amount;
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToDessertspoonUK(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToDessertspoonUK(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToDessertspoonUK(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToDessertspoonUK(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToDessertspoonUK(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToDessertspoonUK(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToDessertspoonUK(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToDessertspoonUK(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToDessertspoonUK(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToDessertspoonUK(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToDessertspoonUK(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToDessertspoonUK(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToDessertspoonUK(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToDessertspoonUK(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToDessertspoonUK(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToDessertspoonUK(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToDessertspoonUK(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToDessertspoonUK(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToDessertspoonUK(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToDessertspoonUK(amount);
        }
    },

    //**************************************** DESSERTSPOON (US) **************************************************

    DESSERTSPOON_US {

        private final int unitKey = 10;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 5;
        }

        @Override
        public int wholeListPosition() {
            return 5;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_dessertspoon_us;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromDessertspoonUS(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToDessertspoonUS(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToDessertspoonUS(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToDessertspoonUS(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToDessertspoonUS(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToDessertspoonUS(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return amount;
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToDessertspoonUS(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToDessertspoonUS(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToDessertspoonUS(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToDessertspoonUS(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToDessertspoonUS(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToDessertspoonUS(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToDessertspoonUS(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToDessertspoonUS(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToDessertspoonUS(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToDessertspoonUS(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToDessertspoonUS(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToDessertspoonUS(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToDessertspoonUS(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToDessertspoonUS(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToDessertspoonUS(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToDessertspoonUS(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToDessertspoonUS(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToDessertspoonUS(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToDessertspoonUS(amount);
        }
    },

    //**************************************** FLUID_OUNCE (UK) **************************************************

    FLUID_OUNCE_UK {

        private final int unitKey = 11;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 6;
        }

        @Override
        public int wholeListPosition() {
            return 6;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_fluid_ounce_uk;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromFluidOunceUK(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToFluidOunceUK(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToFluidOunceUK(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToFluidOunceUK(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToFluidOunceUK(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToFluidOunceUK(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToFluidOunceUK(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return amount;
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToFluidOunceUK(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToFluidOunceUK(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToFluidOunceUK(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToFluidOunceUK(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToFluidOunceUK(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToFluidOunceUK(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToFluidOunceUK(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToFluidOunceUK(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToFluidOunceUK(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToFluidOunceUK(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToFluidOunceUK(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToFluidOunceUK(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToFluidOunceUK(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToFluidOunceUK(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToFluidOunceUK(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToFluidOunceUK(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToFluidOunceUK(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToFluidOunceUK(amount);
        }
    },

    //**************************************** FLUID_OUNCE (US) **************************************************

    FLUID_OUNCE_US {

        private final int unitKey = 12;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 7;
        }

        @Override
        public int wholeListPosition() {
            return 7;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_fluid_ounce_us;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromFluidOunceUS(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToFluidOunceUS(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToFluidOunceUS(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToFluidOunceUS(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToFluidOunceUS(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToFluidOunceUS(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToFluidOunceUS(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToFluidOunceUS(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return amount;
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToFluidOunceUS(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToFluidOunceUS(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToFluidOunceUS(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToFluidOunceUS(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToFluidOunceUS(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToFluidOunceUS(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToFluidOunceUS(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToFluidOunceUS(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToFluidOunceUS(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToFluidOunceUS(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToFluidOunceUS(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToFluidOunceUS(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToFluidOunceUS(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToFluidOunceUS(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToFluidOunceUS(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToFluidOunceUS(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToFluidOunceUS(amount);
        }
    },

    //**************************************** GALLON (UK) **************************************************

    GALLON_UK {

        private final int unitKey = 13;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 8;
        }

        @Override
        public int wholeListPosition() {
            return 8;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_gallon_uk;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromGallonUK(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToGallonUK(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToGallonUK(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToGallonUK(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToGallonUK(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToGallonUK(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToGallonUK(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToGallonUK(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToGallonUK(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return amount;
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToGallonUK(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToGallonUK(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToGallonUK(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToGallonUK(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToGallonUK(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToGallonUK(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToGallonUK(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToGallonUK(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToGallonUK(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToGallonUK(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToGallonUK(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToGallonUK(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToGallonUK(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToGallonUK(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToGallonUK(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToGallonUK(amount);
        }
    },

    //**************************************** GALLON (US, DRY) **************************************************

    GALLON_US_DRY {

        private final int unitKey = 14;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 9;
        }

        @Override
        public int wholeListPosition() {
            return 9;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_gallon_us_dry;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromGallonUSDry(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToGallonUSDry(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToGallonUSDry(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToGallonUSDry(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToGallonUSDry(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToGallonUSDry(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToGallonUSDry(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToGallonUSDry(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToGallonUSDry(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToGallonUSDry(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return amount;
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToGallonUSDry(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToGallonUSDry(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToGallonUSDry(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToGallonUSDry(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToGallonUSDry(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToGallonUSDry(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToGallonUSDry(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToGallonUSDry(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToGallonUSDry(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToGallonUSDry(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToGallonUSDry(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToGallonUSDry(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToGallonUSDry(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToGallonUSDry(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToGallonUSDry(amount);
        }
    },

    //**************************************** GALLON (US, LIQUID) **************************************************

    GALLON_US {

        private final int unitKey = 15;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 10;
        }

        @Override
        public int wholeListPosition() {
            return 10;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_gallon_us;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromGallonUS(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToGallonUS(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToGallonUS(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToGallonUS(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToGallonUS(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToGallonUS(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToGallonUS(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToGallonUS(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToGallonUS(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToGallonUS(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToGallonUS(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return amount;
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToGallonUS(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToGallonUS(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToGallonUS(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToGallonUS(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToGallonUS(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToGallonUS(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToGallonUS(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToGallonUS(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToGallonUS(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToGallonUS(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToGallonUS(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToGallonUS(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToGallonUS(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToGallonUS(amount);
        }
    },

    //**************************************** LITER **************************************************

    LITER{

        private final int unitKey = 16;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 11;
        }

        @Override
        public int wholeListPosition() {
            return 13;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_liter;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromLiter(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToLiter(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToLiter(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToLiter(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToLiter(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToLiter(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToLiter(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToLiter(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToLiter(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToLiter(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToLiter(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToLiter(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return amount;
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToLiter(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToLiter(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToLiter(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToLiter(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToLiter(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToLiter(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToLiter(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToLiter(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToLiter(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToLiter(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToLiter(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToLiter(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToLiter(amount);
        }
    },

    //**************************************** MILLILITER **************************************************

    MILLILITER {

        private final int unitKey = 17;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 12;
        }

        @Override
        public int wholeListPosition() {
            return 14;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_milliliter;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromMilliliter(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToMilliliter(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToMilliliter(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToMilliliter(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToMilliliter(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToMilliliter(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToMilliliter(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToMilliliter(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToMilliliter(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToMilliliter(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToMilliliter(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToMilliliter(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToMilliliter(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return amount;
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToMilliliter(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToMilliliter(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToMilliliter(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToMilliliter(amount);
        }@Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToMilliliter(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToMilliliter(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToMilliliter(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToMilliliter(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToMilliliter(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToMilliliter(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToMilliliter(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToMilliliter(amount);
        }
    },

    //**************************************** PINT (UK) **************************************************

    PINT_UK {

        private final int unitKey = 18;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 13;
        }

        @Override
        public int wholeListPosition() {
            return 17;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_pint_uk;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromPintUK(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToPintUK(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToPintUK(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToPintUK(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToPintUK(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToPintUK(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToPintUK(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToPintUK(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToPintUK(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToPintUK(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToPintUK(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToPintUK(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToPintUK(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToPintUK(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return amount;
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToPintUK(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToPintUK(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToPintUK(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToPintUK(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToPintUK(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToPintUK(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToPintUK(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToPintUK(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToPintUK(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToPintUK(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToPintUK(amount);
        }

    },

    //**************************************** PINT (US, DRY) **************************************************

    PINT_US_DRY {

        private final int unitKey = 19;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 14;
        }

        @Override
        public int wholeListPosition() {
            return 18;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_pint_us_dry;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromPintUSDry(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToPintUSDry(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToPintUSDry(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToPintUSDry(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToPintUSDry(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToPintUSDry(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToPintUSDry(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToPintUSDry(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToPintUSDry(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToPintUSDry(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToPintUSDry(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToPintUSDry(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToPintUSDry(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToPintUSDry(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToPintUSDry(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return amount;
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToPintUSDry(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToPintUSDry(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToPintUSDry(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToPintUSDry(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToPintUSDry(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToPintUSDry(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToPintUSDry(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToPintUSDry(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToPintUSDry(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToPintUSDry(amount);
        }
    },

    //**************************************** PINT (US, LIQUID) **************************************************

    PINT_US {

        private final int unitKey = 20;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 15;
        }

        @Override
        public int wholeListPosition() {
            return 19;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_pint_us;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromPintUS(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToPintUS(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToPintUS(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToPintUS(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToPintUS(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToPintUS(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToPintUS(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToPintUS(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToPintUS(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToPintUS(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToPintUS(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToPintUS(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToPintUS(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToPintUS(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToPintUS(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToPintUS(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return amount;
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToPintUS(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToPintUS(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToPintUS(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToPintUS(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToPintUS(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToPintUS(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToPintUS(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToPintUS(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToPintUS(amount);
        }
    },

    //**************************************** QUART (UK) **************************************************

    QUART_UK {

        private final int unitKey = 21;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 16;
        }

        @Override
        public int wholeListPosition() {
            return 21;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_quart_uk;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromQuartUK(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToQuartUK(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToQuartUK(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToQuartUK(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToQuartUK(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToQuartUK(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToQuartUK(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToQuartUK(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToQuartUK(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToQuartUK(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToQuartUK(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToQuartUK(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToQuartUK(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToQuartUK(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToQuartUK(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToQuartUK(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToQuartUK(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return amount;
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToQuartUK(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToQuartUK(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToQuartUK(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToQuartUK(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToQuartUK(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToQuartUK(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToQuartUK(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToQuartUK(amount);
        }

    },

    //**************************************** QUART (US, DRY) **************************************************

    QUART_US_DRY {

        private final int unitKey = 22;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 17;
        }

        @Override
        public int wholeListPosition() {
            return 22;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_quart_us_dry;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromQuartUSDry(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToQuartUSDry(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToQuartUSDry(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToQuartUSDry(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToQuartUSDry(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToQuartUSDry(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToQuartUSDry(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToQuartUSDry(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToQuartUSDry(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToQuartUSDry(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToQuartUSDry(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToQuartUSDry(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToQuartUSDry(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToQuartUSDry(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToQuartUSDry(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToQuartUSDry(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToQuartUSDry(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToQuartUSDry(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return amount;
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToQuartUSDry(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToQuartUSDry(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToQuartUSDry(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToQuartUSDry(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToQuartUSDry(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToQuartUSDry(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToQuartUSDry(amount);
        }
    },

    //**************************************** QUART (US, LIQUID) **************************************************

    QUART_US {

        private final int unitKey = 23;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 18;
        }

        @Override
        public int wholeListPosition() {
            return 23;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_quart_us;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromQuartUS(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToQuartUS(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToQuartUS(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToQuartUS(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToQuartUS(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToQuartUS(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToQuartUS(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToQuartUS(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToQuartUS(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToQuartUS(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToQuartUS(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToQuartUS(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToQuartUS(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToQuartUS(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToQuartUS(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToQuartUS(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToQuartUS(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToQuartUS(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToQuartUS(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return amount;
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToQuartUS(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToQuartUS(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToQuartUS(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToQuartUS(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToQuartUS(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToQuartUS(amount);
        }
    },

    //**************************************** TABLESPOON (EU) **************************************************

    TABLESPOON_EU {

        private final int unitKey = 24;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 19;
        }

        @Override
        public int wholeListPosition() {
            return 24;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_tablespoon_eu;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromTablespoonEU(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToTablespoonEU(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToTablespoonEU(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToTablespoonEU(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToTablespoonEU(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToTablespoonEU(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToTablespoonEU(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToTablespoonEU(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToTablespoonEU(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToTablespoonEU(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToTablespoonEU(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToTablespoonEU(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToTablespoonEU(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToTablespoonEU(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToTablespoonEU(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToTablespoonEU(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToTablespoonEU(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToTablespoonEU(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToTablespoonEU(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToTablespoonEU(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return amount;
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToTablespoonEU(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToTablespoonEU(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToTablespoonEU(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToTablespoonEU(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToTablespoonEU(amount);
        }
    },

    //**************************************** TABLESPOON (UK) **************************************************

    TABLESPOON_UK {

        private final int unitKey = 25;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 20;
        }

        @Override
        public int wholeListPosition() {
            return 25;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_tablespoon_uk;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromTablespoonUK(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToTablespoonUK(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToTablespoonUK(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToTablespoonUK(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToTablespoonUK(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToTablespoonUK(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToTablespoonUK(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToTablespoonUK(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToTablespoonUK(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToTablespoonUK(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToTablespoonUK(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToTablespoonUK(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToTablespoonUK(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToTablespoonUK(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToTablespoonUK(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToTablespoonUK(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToTablespoonUK(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToTablespoonUK(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToTablespoonUK(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToTablespoonUK(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToTablespoonUK(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return amount;
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToTablespoonUK(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToTablespoonUK(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToTablespoonUK(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToTablespoonUK(amount);
        }
    },

    //**************************************** TABLESPOON (US) **************************************************

    TABLESPOON_US {

        private final int unitKey = 26;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 21;
        }

        @Override
        public int wholeListPosition() {
            return 26;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_tablespoon_us;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromTablespoonUS(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToTablespoonUS(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToTablespoonUS(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToTablespoonUS(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToTablespoonUS(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToTablespoonUS(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToTablespoonUS(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToTablespoonUS(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToTablespoonUS(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToTablespoonUS(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToTablespoonUS(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToTablespoonUS(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToTablespoonUS(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToTablespoonUS(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToTablespoonUS(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToTablespoonUS(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToTablespoonUS(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToTablespoonUS(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToTablespoonUS(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToTablespoonUS(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToTablespoonUS(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToTablespoonUS(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return amount;
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToTablespoonUS(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToTablespoonUS(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToTablespoonUS(amount);
        }

    },

    //**************************************** TEASPOON (EU) **************************************************
    TEASPOON_EU{

        private final int unitKey = 27;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 22;
        }

        @Override
        public int wholeListPosition() {
            return 27;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_teaspoon_eu;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromTeaspoonEU(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToTeaspoonEU(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToTeaspoonEU(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToTeaspoonEU(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToTeaspoonEU(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToTeaspoonEU(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToTeaspoonEU(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToTeaspoonEU(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToTeaspoonEU(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToTeaspoonEU(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToTeaspoonEU(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToTeaspoonEU(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToTeaspoonEU(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToTeaspoonEU(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToTeaspoonEU(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToTeaspoonEU(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToTeaspoonEU(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToTeaspoonEU(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToTeaspoonEU(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToTeaspoonEU(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToTeaspoonEU(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToTeaspoonEU(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToTeaspoonEU(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return amount;
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToTeaspoonEU(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToTeaspoonEU(amount);
        }

    },

    //**************************************** TEASPOON (UK) **************************************************
    TEASPOON_UK{

        private final int unitKey = 28;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 23;
        }

        @Override
        public int wholeListPosition() {
            return 28;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_teaspoon_uk;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromTeaspoonUK(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToTeaspoonUK(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToTeaspoonUK(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToTeaspoonUK(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToTeaspoonUK(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToTeaspoonUK(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToTeaspoonUK(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToTeaspoonUK(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToTeaspoonUK(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToTeaspoonUK(amount);
        }
        @Override
        public double convertFromGallonUSDry(double amount){
            return Converter.gallonUSDryToTeaspoonUK(amount);
        }
        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToTeaspoonUK(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToTeaspoonUK(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToTeaspoonUK(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToTeaspoonUK(amount);
        }
        @Override
        public double convertFromPintUSDry(double amount){
            return Converter.pintUSDryToTeaspoonUK(amount);
        }
        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToTeaspoonUK(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToTeaspoonUK(amount);
        }
        @Override
        public double convertFromQuartUSDry(double amount){
            return Converter.quartUSDryToTeaspoonUK(amount);
        }
        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToTeaspoonUK(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToTeaspoonUK(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToTeaspoonUK(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToTeaspoonUK(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToTeaspoonUK(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return amount;
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return Converter.teaspoonUSToTeaspoonUK(amount);
        }
    },

    //**************************************** TEASPOON (US) **************************************************

    TEASPOON_US {

        private final int unitKey = 29;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int volumeListPosition() {
            return 24;
        }

        @Override
        public int wholeListPosition() {
            return 29;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_teaspoon_us;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        // CONVERSION METHODS

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromTeaspoonUS(amount);
        }
        @Override
        public double convertFromCupUK(double amount) {
            return Converter.cupUKToTeaspoonUS(amount);
        }
        @Override
        public double convertFromCupUS(double amount) {
            return Converter.cupUSToTeaspoonUS(amount);
        }
        @Override
        public double convertFromDeciliter(double amount) {
            return Converter.deciliterToTeaspoonUS(amount);
        }
        @Override
        public double convertFromDessertspoonEU(double amount){
            return Converter.dessertspoonEUToTeaspoonUS(amount);
        }
        @Override
        public double convertFromDessertspoonUK(double amount){
            return Converter.dessertspoonUKToTeaspoonUS(amount);
        }
        @Override
        public double convertFromDessertspoonUS(double amount){
            return Converter.dessertspoonUSToTeaspoonUS(amount);
        }
        @Override
        public double convertFromFluidOunceUK(double amount){
            return Converter.fluidOunceUKToTeaspoonUS(amount);
        }
        @Override
        public double convertFromFluidOunceUS(double amount){
            return Converter.fluidOunceUSToTeaspoonUS(amount);
        }
        @Override
        public double convertFromGallonUK(double amount){
            return Converter.gallonUKToTeaspoonUS(amount);
        }

        @Override
        public double convertFromGallonUSDry(double amount) {
            return Converter.gallonUSDryToTeaspoonUS(amount);
        }

        @Override
        public double convertFromGallonUS(double amount){
            return Converter.gallonUSToTeaspoonUS(amount);
        }
        @Override
        public double convertFromLiter(double amount){
            return Converter.literToTeaspoonUS(amount);
        }
        @Override
        public double convertFromMilliliter(double amount){
            return Converter.milliliterToTeaspoonUS(amount);
        }
        @Override
        public double convertFromPintUK(double amount){
            return Converter.pintUKToTeaspoonUS(amount);
        }

        @Override
        public double convertFromPintUSDry(double amount) {
            return Converter.pintUSDryToTeaspoonUS(amount);
        }

        @Override
        public double convertFromPintUS(double amount){
            return Converter.pintUSToTeaspoonUS(amount);
        }
        @Override
        public double convertFromQuartUK(double amount){
            return Converter.quartUKToTeaspoonUS(amount);
        }

        @Override
        public double convertFromQuartUSDry(double amount) {
            return Converter.quartUSDryToTeaspoonUS(amount);
        }

        @Override
        public double convertFromQuartUS(double amount){
            return Converter.quartUSToTeaspoonUS(amount);
        }
        @Override
        public double convertFromTablespoonEU(double amount){
            return Converter.tablespoonEUToTeaspoonUS(amount);
        }
        @Override
        public double convertFromTablespoonUK(double amount){
            return Converter.tablespoonUKToTeaspoonUS(amount);
        }
        @Override
        public double convertFromTablespoonUS(double amount){
            return Converter.tablespoonUSToTeaspoonUS(amount);
        }
        @Override
        public double convertFromTeaspoonEU(double amount){
            return Converter.teaspoonEUToTeaspoonUS(amount);
        }
        @Override
        public double convertFromTeaspoonUK(double amount){
            return Converter.teaspoonUKToTeaspoonUS(amount);
        }
        @Override
        public double convertFromTeaspoonUS(double amount){
            return amount;
        }

    },

    //*************************************** PIECE (NOT CONVERTABLE) *************************************************

    PIECE {

        private final int unitKey = 30;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int wholeListPosition() {
            return 16;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_short_name_piece;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        @Override
        public boolean isPiece() {
            return true;
        }

        //this unit is not convertable, so other units use the default converting method.
        @Override
        public double convert(Unit target, double amount){
            return target.convertFromPiece(amount);
        }
    },

    //*************************************** CELSIUS *************************************************

    CELSIUS {

        private final int unitKey = 30;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_celsius;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        @Override
        public boolean isPiece() {
            return false;
        }

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromCelsius(amount);
        }

        @Override
        public double convertFromCelsius(double amount) {
            return super.convertFromCelsius(amount);
        }

        @Override
        public double convertFromFahrenheit(double amount) {
            return Converter.fahrenheitToCelsius(amount);
        }
    },

    //*************************************** FAHRENHEIT *************************************************

    FAHRENHEIT {

        private final int unitKey = 31;

        @Override
        public int getUnitKey(){
            return unitKey;
        }

        @Override
        public int getRes() {
            return R.string.array_unit_fahrenheit;
        }

        @Override
        public boolean isMassUnit() {
            return false;
        }

        @Override
        public boolean isPiece() {
            return false;
        }

        @Override
        public double convert(Unit target, double amount){
            return target.convertFromFahrenheit(amount);
        }

        @Override
        public double convertFromCelsius(double amount) {
            return Converter.celsiusToFahrenheit(amount);
        }

        @Override
        public double convertFromFahrenheit(double amount) {
            return super.convertFromFahrenheit(amount);
        }
    };


    //****************************** UNIT METHODS **************************************************

    // These are placeholder methods used to guide the method call to the correct unit.

    public double convert(Unit target, double amount){
        return amount;
    }

    public int getUnitKey(){
        return 0;
    }

    public int massListPosition() {
        return 0;
    }

    public int volumeListPosition() {
        return 0;
    }

    public int wholeListPosition() {
        return 0;
    }

    public int getRes() {
        return 0;
    }

    public boolean isMassUnit(){
       return false;
    }

    //special case for non-convertable unit
    public boolean isPiece(){ return false; }

    // MASS UNITS

    public double convertFromGram(double amount){
        return amount;
    }

    public double convertFromKilogram(double amount){
        return amount;
    }

    public double convertFromOunce(double amount){
        return amount;
    }

    public double convertFromPound(double amount){
        return amount;
    }

    // VOLUME UNITS

    public double convertFromCupUK(double amount){
        return amount;
    }

    public double convertFromCupUS(double amount){
        return amount;
    }

    public double convertFromDeciliter(double amount){
        return amount;
    }

    public double convertFromDessertspoonEU(double amount){
        return amount;
    }

    public double convertFromDessertspoonUK(double amount){
        return amount;
    }

    public double convertFromDessertspoonUS(double amount){
        return amount;
    }

    public double convertFromFluidOunceUK(double amount){
        return amount;
    }

    public double convertFromFluidOunceUS(double amount){
        return amount;
    }

    public double convertFromGallonUK(double amount){
        return amount;
    }

    public double convertFromGallonUSDry(double amount){
        return amount;
    }

    public double convertFromGallonUS(double amount){
        return amount;
    }

    public double convertFromLiter(double amount){
        return amount;
    }

    public double convertFromMilliliter(double amount){
        return amount;
    }

    public double convertFromPintUK(double amount){
        return amount;
    }

    public double convertFromPintUSDry(double amount){
        return amount;
    }

    public double convertFromPintUS(double amount){
        return amount;
    }

    public double convertFromQuartUK(double amount){
        return amount;
    }

    public double convertFromQuartUSDry(double amount){
        return amount;
    }

    public double convertFromQuartUS(double amount){
        return amount;
    }

    public double convertFromTablespoonEU(double amount){
        return amount;
    }

    public double convertFromTablespoonUK(double amount){
        return amount;
    }

    public double convertFromTablespoonUS(double amount){
        return amount;
    }

    public double convertFromTeaspoonEU(double amount){
        return amount;
    }

    public double convertFromTeaspoonUK(double amount){
        return amount;
    }

    public double convertFromTeaspoonUS(double amount){
        return amount;
    }

    public double convertFromPiece(double amount){
        return amount;
    }

    // TEMPERATURE UNITS

    public double convertFromCelsius(double amount) {
        return amount;
    }

    public double convertFromFahrenheit(double amount) {
        return amount;
    }
}
