package jvm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

/**
 * @sees Java 获取内存使用情况https://blog.csdn.net/qq_25034451/article/details/79483591
 * @author daiwei
 * @date 2018/11/27 15:26
 */
public class MemoryTest {

    public static void main(String[] args) {
        System.out.println("TotalMemory"+Runtime.getRuntime().totalMemory()/(1024*1024)+"M");
        System.out.println("FreeMemory"+Runtime.getRuntime().freeMemory()/(1024*1024)+"M");
        System.out.println("MaxMemory"+Runtime.getRuntime().maxMemory()/(1024*1024)+"M");
        System.out.println("UsedMemory"+(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/(1024*1024)+"M");

        System.out.println("  ---------------------");
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

        MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage(); //椎内存使用情况

        long totalMemorySize = memoryUsage.getInit(); //初始的总内存

        long maxMemorySize = memoryUsage.getMax(); //最大可用内存

        long usedMemorySize = memoryUsage.getUsed(); //已使用的内存

        System.out.println("TotalMemory"+totalMemorySize/(1024*1024)+"M");
        System.out.println("FreeMemory"+(totalMemorySize-usedMemorySize)/(1024*1024)+"M");
        System.out.println("MaxMemory"+maxMemorySize/(1024*1024)+"M");
        System.out.println("UsedMemory"+usedMemorySize/(1024*1024)+"M");








    }
}
