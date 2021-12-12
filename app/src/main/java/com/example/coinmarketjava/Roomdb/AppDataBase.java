package com.example.coinmarketjava.Roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.coinmarketjava.Roomdb.Entities.RoomAllMarket;
import com.example.coinmarketjava.Roomdb.Entities.RoomDataMarket;
import com.example.coinmarketjava.Roomdb.converter.AllCoinMarketTypeConverter;
import com.example.coinmarketjava.Roomdb.converter.MarketCryptoDataTypeConverter;

@TypeConverters({AllCoinMarketTypeConverter.class, MarketCryptoDataTypeConverter.class})
@Database(version = 2, entities = {RoomAllMarket.class, RoomDataMarket.class}, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance;
    public final static String nameDataBase = "db_room";


    public static synchronized AppDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDataBase.class, nameDataBase)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract RoomDao roomDao();
}
