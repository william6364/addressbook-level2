package seedu.addressbook.commands;

import java.util.*;
import java.util.stream.Collectors;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";

    private final Set<String> keywords;

    public FindCommand(Set<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * Returns a copy of keywords in this command.
     */
    public Set<String> getKeywords() {
        return new HashSet<>(keywords);
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingAnyKeyword(keywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingAnyKeyword(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        Set<String> upperCaseKeywords = changeStringsToUpperCase(keywords);
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final Set<String> wordsInName = changeStringsToUpperCase(new HashSet<>(person.getName().getWordsInName()));
            if (!Collections.disjoint(wordsInName, upperCaseKeywords)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

    /**
     * Transform all the strings in a collection to upper case and return them in a Set
     */
    private Set<String> changeStringsToUpperCase(Set<String> collectionOfStrings) {
        return collectionOfStrings.stream() // Convert Set to Stream
                .map(String::toUpperCase) // Convert each element to upper case
                .collect(Collectors.toSet()); // Collect results into a new Set
    }

}
