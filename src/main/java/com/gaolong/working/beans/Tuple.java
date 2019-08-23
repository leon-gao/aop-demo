package com.gaolong.working.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public class Tuple<L,R> implements Serializable {

    private L left;

    private R right;

    public Tuple(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public Tuple() {
    }
}
