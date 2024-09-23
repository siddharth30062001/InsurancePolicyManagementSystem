
package InsurancePolicyManagementSystem;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class PolicyManager {
    // Sets for managing policies
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();

    // Add a policy to all sets
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    // Retrieve all unique policies (from any set, e.g., HashSet)
    public Set<Policy> getAllUniquePolicies() {
        return new HashSet<>(hashSet);
    }

    // Retrieve policies expiring within the next 30 days
    public Set<Policy> getPoliciesExpiringSoon() {
        Set<Policy> expiringSoon = new TreeSet<>();
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date thirtyDaysFromNow = calendar.getTime();

        for (Policy policy : treeSet) {
            if (policy.getExpiryDate().before(thirtyDaysFromNow)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    // Retrieve policies by coverage type
    public Set<Policy> getPoliciesByCoverage(String coverageType) {
        Set<Policy> policiesByCoverage = new HashSet<>();
        for (Policy policy : hashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                policiesByCoverage.add(policy);
            }
        }
        return policiesByCoverage;
    }

    // Find duplicate policies based on policy number
    public Set<Policy> findDuplicatePolicies() {
        Set<Policy> duplicates = new HashSet<>();
        Set<String> policyNumbers = new HashSet<>();

        for (Policy policy : hashSet) {
            if (!policyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

    // Compare performance of adding policies to different sets
    public void comparePerformance(List<Policy> policies) {
        long startTime, endTime;

        // HashSet performance
        startTime = System.nanoTime();
        for (Policy policy : policies) {
            hashSet.add(policy);
        }
        endTime = System.nanoTime();
        System.out.println("HashSet add time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");

        // LinkedHashSet performance
        startTime = System.nanoTime();
        for (Policy policy : policies) {
            linkedHashSet.add(policy);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet add time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");

        // TreeSet performance
        startTime = System.nanoTime();
        for (Policy policy : policies) {
            treeSet.add(policy);
        }
        endTime = System.nanoTime();
        System.out.println("TreeSet add time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");
    }
}
