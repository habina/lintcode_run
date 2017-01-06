package com.google.phone;

import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iter;
    int next;
    boolean cached;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iter = iterator;
        this.cached = false;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!this.cached) {
            next = this.iter.next();
            this.cached = true;
        }
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (this.cached) {
            this.cached = false;
            return next;
        } else {
            return this.iter.next();
        }
    }

    @Override
    public boolean hasNext() {
        return this.cached || this.iter.hasNext();
    }

    @Override
    public void remove() {
        if (this.cached) {
            this.cached = false;
        } else {
            this.iter.remove();
        }
    }
}