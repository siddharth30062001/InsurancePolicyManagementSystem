package InsurancePolicyManagementSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Policy policy1 = new Policy("P001", "John Doe", sdf.parse("2024-10-01"), "Health", 1200.50);
        Policy policy2 = new Policy("P002", "Jane Smith", sdf.parse("2024-09-15"), "Auto", 950.75);
        Policy policy3 = new Policy("P003", "Mike Johnson", sdf.parse("2024-09-25"), "Home", 600.30);
        Policy policy4 = new Policy("P001", "John Doe", sdf.parse("2024-11-05"), "Health", 1200.50); // Duplicate by policy number

        PolicyManager policyManager = new PolicyManager();

        // Adding policies
        policyManager.addPolicy(policy1);
        policyManager.addPolicy(policy2);
        policyManager.addPolicy(policy3);
        policyManager.addPolicy(policy4); // Duplicate

        // Retrieve all unique policies
        System.out.println("All Unique Policies: " + policyManager.getAllUniquePolicies());

        // Retrieve policies expiring soon (within 30 days)
        System.out.println("Policies Expiring Soon: " + policyManager.getPoliciesExpiringSoon());

        // Retrieve policies by coverage type
        System.out.println("Health Coverage Policies: " + policyManager.getPoliciesByCoverage("Health"));

        // Find duplicate policies by policy number
        System.out.println("Duplicate Policies: " + policyManager.findDuplicatePolicies());

        // Compare performance of different sets
        List<Policy> samplePolicies = new ArrayList<>();
        samplePolicies.add(policy1);
        samplePolicies.add(policy2);
        samplePolicies.add(policy3);
        samplePolicies.add(policy4);
        policyManager.comparePerformance(samplePolicies);
    }
}
