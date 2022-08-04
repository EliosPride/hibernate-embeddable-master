package ma.hibernate.embeddable.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "size", column = @Column(name = "data_size")),
        @AttributeOverride(name = "hashSum", column = @Column(name = "data_hash_sum"))
})
public class PostMetadata {
    private long size; // in bytes
    private String hashSum;

    public PostMetadata() {
    }

    public PostMetadata(long size, String hashSum) {
        this.size = size;
        this.hashSum = hashSum;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getHashSum() {
        return hashSum;
    }

    public void setHashSum(String hashSum) {
        this.hashSum = hashSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostMetadata that = (PostMetadata) o;
        return size == that.size && Objects.equals(hashSum, that.hashSum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, hashSum);
    }

    @Override
    public String toString() {
        return "PostMetadata{" +
                "size=" + size +
                ", hashSum='" + hashSum + '\'' +
                '}';
    }
}
