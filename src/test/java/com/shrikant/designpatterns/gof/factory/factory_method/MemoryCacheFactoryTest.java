package com.shrikant.designpatterns.gof.factory.factory_method;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MemoryCacheFactoryTest { 

  @Test
  public void check_that_different_types_of_objects_are_created() {

    //given
    final MemoryCache<String, String> studentCache = new GoogleCacheFactory<String, String>().createCache("Cache is implemented using google cache.");
    final MemoryCache<String, String> teacherCache = new CustomMemCacheFactory<String, String>().createCache("In house cache implementation.");
    studentCache.put("first.student@example.com", "studentId: S123, firstName: first, lastName: last");
    studentCache.put("second.student@example.com", "studentId: S456, firstName: second, lastName: last");

    teacherCache.put("first.teacher@example.com", "teacherId: T123, firstName: first, lastName: last");
    teacherCache.put("second.teacher@example.com", "teacherId: T456, firstName: second, lastName: last");

    //then
    assertThat("student cache should be of type : GoogleCache", studentCache.getCacheName(), is("Cache is implemented using google cache."));
    assertThat(teacherCache.getCacheName(), is("In house cache implementation."));

    assertThat(studentCache, instanceOf(GoogleCache.class));
    assertThat(teacherCache, instanceOf(CustomMemCache.class));
  }

}