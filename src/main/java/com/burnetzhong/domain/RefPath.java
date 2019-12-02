package com.burnetzhong.domain;

import com.burnetzhong.domain.refs.GenericRef;
import com.burnetzhong.domain.refs.RefFormat;
import com.burnetzhong.domain.refs.RefType;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Helmsdown on 7/8/15.
 * <p>
 * This class extends directly from Path for now. At some future date we will need
 * to make {@link Path} an interface to follow the pattern established by
 * {@link Model}, {@link com.burnetzhong.domain.properties.Object} and {@link com.burnetzhong.domain.parameters.Parameter}
 */
public class RefPath extends Path {

    private GenericRef genericRef;

    public RefPath() {
    }

    public RefPath(String ref) {
        set$ref(ref);
    }

    public void set$ref(String ref) {
        this.genericRef = new GenericRef(RefType.PATH, ref);
    }

    public String get$ref() {
        return genericRef.getRef();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefPath refPath = (RefPath) o;

        return !(genericRef != null ? !genericRef.equals(refPath.genericRef) : refPath.genericRef != null);

    }

    @Override
    public int hashCode() {
        return genericRef != null ? genericRef.hashCode() : 0;
    }

    @JsonIgnore
    public RefFormat getRefFormat() {
        return this.genericRef.getFormat();
    }

}
