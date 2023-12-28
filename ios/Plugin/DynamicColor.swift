import Foundation

@objc public class DynamicColor: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
