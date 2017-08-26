package org.apache.solr.handler.dataimport;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by phoebe.shih on 2017/5/13.
 */
public class HBaseEntityProcessor extends SqlEntityProcessor{

    protected DataSource<Iterator<Map<String, Object>>> dataSource;

    @Override
    public void init(Context context) {
        super.init(context);
        dataSource = context.getDataSource();
    }

    @Override
    public Map<String, Object> nextRow() {
        if (rowIterator == null) {
            rowIterator = dataSource.getData("");
        }
        return getNext();
    }

    @Override
    public void destroy(){
        dataSource.close();
    }
}
