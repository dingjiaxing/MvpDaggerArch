package com.jackting.mvpdaggerarch.data.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.jackting.mvpdaggerarch.bean.entity.Article;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ARTICLE".
*/
public class ArticleDao extends AbstractDao<Article, Void> {

    public static final String TABLENAME = "ARTICLE";

    /**
     * Properties of entity Article.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, int.class, "id", false, "ID");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Desc = new Property(2, String.class, "desc", false, "DESC");
        public final static Property NiceDate = new Property(3, String.class, "niceDate", false, "NICE_DATE");
        public final static Property Link = new Property(4, String.class, "link", false, "LINK");
        public final static Property Author = new Property(5, String.class, "author", false, "AUTHOR");
        public final static Property PublishTime = new Property(6, long.class, "publishTime", false, "PUBLISH_TIME");
    }


    public ArticleDao(DaoConfig config) {
        super(config);
    }
    
    public ArticleDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ARTICLE\" (" + //
                "\"ID\" INTEGER NOT NULL ," + // 0: id
                "\"TITLE\" TEXT," + // 1: title
                "\"DESC\" TEXT," + // 2: desc
                "\"NICE_DATE\" TEXT," + // 3: niceDate
                "\"LINK\" TEXT," + // 4: link
                "\"AUTHOR\" TEXT," + // 5: author
                "\"PUBLISH_TIME\" INTEGER NOT NULL );"); // 6: publishTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ARTICLE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Article entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(3, desc);
        }
 
        String niceDate = entity.getNiceDate();
        if (niceDate != null) {
            stmt.bindString(4, niceDate);
        }
 
        String link = entity.getLink();
        if (link != null) {
            stmt.bindString(5, link);
        }
 
        String author = entity.getAuthor();
        if (author != null) {
            stmt.bindString(6, author);
        }
        stmt.bindLong(7, entity.getPublishTime());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Article entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(3, desc);
        }
 
        String niceDate = entity.getNiceDate();
        if (niceDate != null) {
            stmt.bindString(4, niceDate);
        }
 
        String link = entity.getLink();
        if (link != null) {
            stmt.bindString(5, link);
        }
 
        String author = entity.getAuthor();
        if (author != null) {
            stmt.bindString(6, author);
        }
        stmt.bindLong(7, entity.getPublishTime());
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public Article readEntity(Cursor cursor, int offset) {
        Article entity = new Article( //
            cursor.getInt(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // desc
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // niceDate
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // link
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // author
            cursor.getLong(offset + 6) // publishTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Article entity, int offset) {
        entity.setId(cursor.getInt(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDesc(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setNiceDate(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setLink(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setAuthor(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setPublishTime(cursor.getLong(offset + 6));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(Article entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(Article entity) {
        return null;
    }

    @Override
    public boolean hasKey(Article entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
