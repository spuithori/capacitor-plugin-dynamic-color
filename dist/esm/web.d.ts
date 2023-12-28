import { WebPlugin } from '@capacitor/core';
import type { DynamicColorPlugin } from './definitions';
export declare class DynamicColorWeb extends WebPlugin implements DynamicColorPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    getDynamicColors(): Promise<{
        value: string;
    }>;
}
