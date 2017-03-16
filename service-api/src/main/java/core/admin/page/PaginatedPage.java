package core.admin.page;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class PaginatedPage<T> implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(PaginatedPage.class);

    private static final long serialVersionUID = 8253560400989720300L;

    public static final Integer DEFAULT_PAGE_SIZE = 100;

    private Integer size = DEFAULT_PAGE_SIZE;

    private Integer count;
    private List<T> datum;

    private Integer page;
    private Integer total;

    private Integer offset;
    private Integer limit;

    private PaginatedPage(){
        this.page = 1;
    }

    private PaginatedPage(Integer page){
        this.page = page;
    }

    public static <T> PaginatedPage<T> create(Integer page) {
        return new PaginatedPage<T>(page);
    }

    public interface PaginatedCallback<T> {
        List<T> execute(Integer offset, Integer limit);
    }

    public void setDatum(PaginatedCallback<T> callback) {
        if (total == 0) {
            return;
        }

        this.datum = callback.execute(offset, limit);
    }

    /**
     * 计算offset和limit
     */
    public void computePaginatedVars() {
        this.total = (count / size) + (count % size > 0 ? 1 : 0);
        this.page = (this.page == null || this.page <= 0 || this.total == 0) ? 1 : this.page > this.total ? this.total : this.page;
        this.offset = (this.page - 1) * size > count ? count : (this.page - 1) * size;
        this.limit = this.page * size > count ? count - this.offset : size;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
        computePaginatedVars();
    }

    @JsonIgnore
    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @JsonIgnore
    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<T> getDatum() {
        return datum;
    }
}
